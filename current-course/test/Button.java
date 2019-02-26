import javax.swing.*;
import java.awt.*;
public class Button {
	public static void main(String[] args) {
		JFrame frame=new JFrame("按钮显示");
		Container container=frame.getContentPane();
		frame.setLayout(new GridLayout(1,3));
	    JButton b1 = new JButton("向前", new ImageIcon("prev.gif"));
	    JButton b2 = new JButton("显示当前");
	    JButton b3 = new JButton("向后",new ImageIcon("next.gif"));
	    container.add(b1);	
        container.add(b2);
	    container.add(b3);
	    frame.setVisible(true);
	    frame.pack();
	}
}
