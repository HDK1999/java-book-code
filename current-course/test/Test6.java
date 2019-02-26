import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class Test6 extends JFrame{
	public Test6() {		
		Container con = this.getContentPane();  	
    	con.setLayout(new FlowLayout());  	
    	JTextField jtf = new JTextField("");
    	jtf.setPreferredSize(new Dimension(150, 20));
    	//添加按键监听器
    	jtf.addKeyListener(new KeyAdapter() {
            //如果输入的是字符'a'，那么将字符编程'A'
			public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_A)
                {
                	System.out.println("按下了键："+e.getKeyChar());
                	e.setKeyChar((char)(KeyEvent.VK_A+32));
                	System.out.println("转化以后为："+e.getKeyChar());
                }
				super.keyTyped(e);
			}
			public void keyPressed(KeyEvent e) {
                System.out.println("键盘输入！");
				super.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
		        System.out.println("键盘释放！");
				super.keyReleased(e);
			}   		
		});    	
    	con.add(jtf); 


	}

	
	public static void main(String[] args){
		int i=10;
		i=i++;
		System.out.println(i);
	}
}


