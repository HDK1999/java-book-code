package test1;

class Parent{
	private static int s=staticInit("Parent.s");
	private int i=1;
	protected int j=2;
	
	public Parent(){
		System.out.println("construct Parent "+(i+s));
	}
	static int staticInit(String str){
		System.out.println("init static "+str);
		return 3;
	}
	public int nonstaticinit(String str){
		System.out.println("init "+str);
		return 4;
	}
}
public class Child extends Parent{
	private static int s=staticInit("Child.s");
	private int k=nonstaticinit("k");
	
	public Child(){
		System.out.println("construct Child "+(j+k));
	}
	public static void main(String[] args){
		Child c=new Child();
	}
}

