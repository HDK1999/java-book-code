import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action occurred");
		System.out.println("Button's label is:" + e.getActionCommand());
	}
}

public class TestButton {
	public static void main(String[] args) {
		JFrame f = new JFrame("test");
		f.setSize(200, 100);
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b = new JButton("press me");
		b.addActionListener(new ButtonHandler());
		f.add(b);
		f.setVisible(true);
	}
}