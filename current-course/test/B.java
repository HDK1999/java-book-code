import abc.A;

class A { 
	public int Avar=1; 
	public A() { 
		System.out.println("A Constructor"); 
		doSomething(); 
	} 
	public void doSomething() { 
		Avar = 1111; 
		System.out.println("A.doSomething()"); 
	}
}
public class B extends A {
	public int Bvar = 2222; 
	public B() { 
		System.out.println("B Constructor"); 
		doSomething(); 
		System.out.println("Avar=" + Avar); 
	} 
	public void doSomething() { 
		System.out.println("Bvar=" + Bvar); 
	} 
	public static void main(String[] args) { 
		new B();
	} 
}

