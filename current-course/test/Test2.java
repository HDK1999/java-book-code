//import java.io.ObjectOutputStream;
import java.io.*;
import java.awt.*;

import abc.C;

class C implements Serializable{
	static int t1=1;
	static {System.out.println(Test2.t2);}
	public C(){
		System.out.println("C");
		mtd();
	}
	
	public void mtd(){
		System.out.println("C method");
	}
}

public class Test2 extends C{
	static int t2=2;
	public Test2(){
		System.out.println("Test2");
		mtd();
	}
	
	public void mtd(){
		System.out.println("Test2 method ");
	}
	public static void main(String[] args){
		GraphicsEnvironment local = GraphicsEnvironment.getLocalGraphicsEnvironment( );
		String[ ]  fonts = local.getAvailableFontFamilyNames( );

		for(String s: fonts)
			System.out.println(s);
	}
}
