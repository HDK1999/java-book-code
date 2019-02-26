package ExampleSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxDemo extends JPanel implements ActionListener {
	JLabel picture;

	public ComboBoxDemo() {
		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

		// Create the combo box, select the pig
		JComboBox petList = new JComboBox(petStrings);
		petList.setSelectedIndex(4);
		petList.addActionListener(this);

		// Set up the picture
		picture = new JLabel(new ImageIcon("ExampleSwing/images/"
				+ petStrings[petList.getSelectedIndex()] + ".gif"));
		picture.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		// The preferred size is hard-coded to be the width of the
		// widest image and the height of the tallest image + the border.
		// A real program would compute this.
		picture.setPreferredSize(new Dimension(177, 122 + 10));

		// Layout the demo
		setLayout(new BorderLayout());
		add(petList, BorderLayout.NORTH);
		add(picture, BorderLayout.SOUTH);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox) e.getSource();
		String petName = (String) cb.getSelectedItem();
		picture.setIcon(new ImageIcon("ExampleSwing/images/" + petName + ".gif"));
	}

	public static void main(String s[]) {
		JFrame frame = new JFrame("ComboBoxDemo");

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add(new ComboBoxDemo(), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
