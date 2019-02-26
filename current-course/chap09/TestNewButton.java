import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestNewButton extends JFrame implements ActionListener {
	Container to_add;

	public TestNewButton(String s) {
		super(s);
	}

	public void actionPerformed(ActionEvent e) {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		JButton b = new JButton("hahaha!");
		b.addActionListener(this);

		p.add(b, BorderLayout.CENTER);
		to_add.add(p, BorderLayout.SOUTH);
		to_add = p;
		this.setVisible(true);
	}

	public static void main(String[] args) {
		TestNewButton f = new TestNewButton("test");
		f.to_add = f.getContentPane();
		f.setSize(200, 100);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton b = new JButton("press me");
		b.addActionListener(f);
		f.add(b, BorderLayout.CENTER);

		f.setVisible(true);
	}
}