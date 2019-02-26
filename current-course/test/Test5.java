import java.util.*;
import java.io.*;

class AA implements Serializable{}

class BB extends AA{}

class CC extends AA{}

public class Test5{
	public static void main(String[] args){
		int i=2;
		float f=2.0f;
		double d=4.0;
		
		//首先float*int转换为float*float，然后float==double转换为double==double
		System.out.println(0.0==0.0);
		
		byte b=0x1f;
		char c='G';
		//byte&char转换为int&int
		System.out.println(Integer.toHexString(b&c));
		
		f = (b==0) ? i : 6.0f; //int:float转换为float:float
		System.out.println(f/2.0); //float/double转换为double/double		
	}
}