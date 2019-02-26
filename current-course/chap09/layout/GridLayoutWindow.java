package layout;

import java.awt.*;
import javax.swing.*;

public class GridLayoutWindow extends JFrame {
	public GridLayoutWindow() {
		setLayout(new GridLayout(0, 2));
		add(new JButton("Button 1"));
		add(new JButton("2"));
		add(new JButton("Button 3"));
		add(new JButton("Long-Named Button 4"));
		add(new JButton("Button 5"));
		add(new JButton("6"));
	}

	public static void main(String[] args) {
		GridLayoutWindow glw = new GridLayoutWindow();
		glw.setTitle("GridWindow Application");
		glw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		glw.pack();
		glw.setVisible(true);
	}
}