package layout;

import java.awt.*;
import javax.swing.*;

public class FlowLayoutWindow extends JFrame {
	public FlowLayoutWindow() {
		setLayout(new FlowLayout());
		add(new JLabel("Buttons: "));
		add(new JButton("Button 1"));
		add(new JButton("2"));
		add(new JButton("Button 3"));
		add(new JButton("Long-Named Button 4"));
		add(new JButton("Button 5"));
	}

	public static void main(String args[]) {
		FlowLayoutWindow flw = new FlowLayoutWindow();
		flw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		flw.setTitle("FlowLayoutWindow Application");
		flw.pack();
		flw.setVisible(true);
	}
}