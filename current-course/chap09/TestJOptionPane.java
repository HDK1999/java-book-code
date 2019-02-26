import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Listener1 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "Eggs aren't supported to be green");

		// JOptionPane.showMessageDialog(null,
		// "Eggs aren't supposed to be green",
		// "Warning",JOptionPane.WARNING_MESSAGE);
	}
}

class Listener2 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Object[] options = { "Yes, please", "No, thanks", "No eggs, no ham!" };
		int n = JOptionPane.showOptionDialog(null,
				"Would you like some green eggs to go " + "with that ham?",
				"A Silly Question", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
	}
}

class Listener3 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Object[] possibleValues = { "First", "Second", "Third" };
		Object selectedValue = JOptionPane.showInputDialog(null, "Choose one",
				"Input", JOptionPane.INFORMATION_MESSAGE, null, possibleValues,
				possibleValues[0]);

		//String inputValue=JOptionPane.showInputDialog("Please input a value");
	}
}

class Listener4 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showConfirmDialog(null, "choose one", "choose one",
				JOptionPane.YES_NO_OPTION);
	}
}

public class TestJOptionPane extends JFrame {
	public TestJOptionPane() {
		super("TestJOptionPane App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		JButton b1 = new JButton("message dialog");
		JButton b2 = new JButton("option dialog");
		JButton b3 = new JButton("input dialog");
		JButton b4 = new JButton("confirm dialog");

		b1.addActionListener(new Listener1());
		b2.addActionListener(new Listener2());
		b3.addActionListener(new Listener3());
		b4.addActionListener(new Listener4());

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		TestJOptionPane pane = new TestJOptionPane();
	}
}