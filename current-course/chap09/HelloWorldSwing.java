import javax.swing.*;
import java.awt.event.*;

public class HelloWorldSwing {
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException,
			ClassNotFoundException {

		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

		JFrame frame = new JFrame("HelloWorldSwing");//
		final JLabel label = new JLabel("Hello World!");
		frame.getContentPane().add(label);

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		frame.setSize(200, 70);
		frame.setVisible(true);
	}
}