import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestJScrollPane {
	public TestJScrollPane() {
		JFrame f = new JFrame("JScrollPane Application");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout());
		f.setSize(100, 50);

		JTextArea textArea = new JTextArea(5, 30);

		JScrollPane sp = new JScrollPane(textArea);
		// JScrollPane sp=new
		// JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		// JScrollPane sp=new
		// JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		f.getContentPane().add(sp);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String args[]) {
		TestJScrollPane tsp = new TestJScrollPane();
	}
}