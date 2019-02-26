package layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutWindow extends JFrame {
	public BorderLayoutWindow() {
		setLayout(new BorderLayout(5, 5));
		add(new JButton("North"), "North");
		add(new JButton("South"), "South");
		add(new JButton("East"), "East");
		add(new JButton("West"), "West");
		add(new JButton("Center"), "Center");
	}

	public static void main(String args[]) {
		BorderLayoutWindow window = new BorderLayoutWindow();
		window.setTitle("BorderLayoutWindow Application");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
}