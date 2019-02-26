package ExampleSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class ButtonDemo extends JPanel implements java.awt.event.ActionListener {

	JButton b1, b2, b3;

	public ButtonDemo() {
		super();
		ImageIcon leftButtonIcon = new ImageIcon(
				"ExampleSwing/images/right.gif");
		ImageIcon middleButtonIcon = new ImageIcon(
				"ExampleSwing/images/middle.gif");
		ImageIcon rightButtonIcon = new ImageIcon(
				"ExampleSwing/images/left.gif");

		// XXX: In 1.0.2 only, must use FixedJButton instead of JButton
		// XXX: to get button mnemonics.
		// XXX: See ui/swing/workaround.html for details.
		b1 = new JButton("Disable middle button", leftButtonIcon);
		b1.setVerticalTextPosition(AbstractButton.CENTER);
		b1.setHorizontalTextPosition(AbstractButton.LEFT);
		b1.setMnemonic('d');
		b1.setActionCommand("disable");

		b2 = new JButton("Middle button", middleButtonIcon);
		b2.setVerticalTextPosition(AbstractButton.BOTTOM);
		b2.setHorizontalTextPosition(AbstractButton.CENTER);
		b2.setMnemonic('m');

		b3 = new JButton("Enable middle button", rightButtonIcon);
		// Use the default text position of CENTER, RIGHT.
		b3.setMnemonic('e');
		b3.setActionCommand("enable");
		b3.setEnabled(false);

		// Listen for actions on buttons 1 and 3.
		b1.addActionListener(this);
		b3.addActionListener(this);

		// Add Components to this container, using the default FlowLayout.
		add(b1);
		add(b2);
		add(b3);
	}

	public void actionPerformed(java.awt.event.ActionEvent e) {
		if (e.getActionCommand().equals("disable")) {
			b2.setEnabled(false);
			b1.setEnabled(false);
			b3.setEnabled(true);
		} else {
			b2.setEnabled(true);
			b1.setEnabled(true);
			b3.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		/*
		 * Create a window. Use JFrame since this window will include
		 * lightweight components.
		 */
		JFrame frame = new JFrame("ButtonDemo");

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add(new ButtonDemo(), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}
}
