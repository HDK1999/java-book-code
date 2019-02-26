package layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxLayoutWindow extends JFrame {
	public BoxLayoutWindow() {
		Container contentPane = getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		addAButton("Button1", contentPane);
		addAButton("2", contentPane);
		addAButton("Button3", contentPane);
		addAButton("Long-Named Button 4", contentPane);
		addAButton("Button5", contentPane);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private void addAButton(String text, Container container) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(button);
	}

	public static void main(String[] args) {
		BoxLayoutWindow window = new BoxLayoutWindow();
		window.setTitle("BoxLayout Application");
		window.pack();
		window.setVisible(true);
	}
}