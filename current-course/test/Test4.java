import java.util.*;
import java.io.*;

public class Test4{
	public static void main(String[] args){
				
		int[][] x=new int[3][4];
		System.out.println(x.length-x[2].length);
		
		float f=0.9235f;
		System.out.println(f==0.9235);
		
		System.out.println(Double.NaN!=Double.NaN);
		
		/*byte a=1, b;
		b=-a;
		System.out.println(b);*/
		
		System.out.println(7.5%3.5);
		
		int i=5;
		int j= (i++) + (i++) + (i++);
		System.out.println(i+";"+j);

	}
}

class C{
	
}
class D{
	
}
interface S{
	
}
interface T{
	
}

//class A extends C implements S,T {}
//class A extends C,D implements S {}
//class A extends T implements S {}
//class A extends C implements D {}