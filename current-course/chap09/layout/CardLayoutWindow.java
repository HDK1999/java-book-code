package layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutWindow extends JFrame implements ActionListener {
	JPanel cards;
	CardLayout cl = new CardLayout();

	public CardLayoutWindow() {
		setLayout(new BorderLayout());// 设置Frame为BorderLayout
		// 创建摆放“卡片切换”按钮的Panel，并添加到Frame中
		JPanel cp = new JPanel();
		JButton bt = new JButton("卡片切换");
		bt.addActionListener(this);
		cp.add(bt);
		add("North", cp);

		// 创建盛放多个卡片的Panel，设置为CardLayout
		cards = new JPanel();
		cards.setLayout(cl);

		// 创建cards中的第一个Panel及其组件
		JPanel p1 = new JPanel();
		p1.add(new JButton("Button 1"));
		p1.add(new JButton("Button 2"));
		p1.add(new JButton("Button 3"));

		// 创建cards中的另一个Panel及其组件
		JPanel p2 = new JPanel();
		p2.add(new JTextField("TextField", 20));

		// 把两个Panel加入到cards中
		cards.add("Panel with Buttons", p1);
		cards.add("Panel with TextField", p2);

		// 将cards放入Frame中
		add("Center", cards);
	}

	public void actionPerformed(ActionEvent e) {
		cl.next(cards);
	}

	public static void main(String[] args) {
		CardLayoutWindow clw = new CardLayoutWindow();
		clw.setTitle("CardWindow Application");
		clw.pack();
		clw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clw.setVisible(true);
	}
}