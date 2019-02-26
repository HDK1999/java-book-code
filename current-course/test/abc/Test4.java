package abc;
import java.util.*;
import java.io.*;

public class Test4 extends Super implements S,T {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test4 other = (Test4) obj;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		return true;
	}

	String s="t";
	
	public void f(){}
	
	public static void main(String[] args){
		Test4 t=new Test4();
		System.out.println(t.a);
	}
}
class Super{
	String s="s";
}

class C{
	
}
class D{
	
}
abstract interface S{
	int a=3;
	void f();
}
abstract interface T{
	int a=4;
	void f();
}

//class A extends C implements S,T {}
//class A extends C,D implements S {}
//class A extends T implements S {}
//class A extends C implements D {}