package abc;

public class Test extends Base{
	private int i=2;
	public void printI(){
		System.out.println(this.i);
		System.out.println(this.getI());
	}
	public static void main(String[] args){
		
		System.out.println(Float.NaN!=2);

		
		Base base=new Test();
		base.increase();
		base.printI();
		
		if(base instanceof Test){
			Test sub=(Test)base;
			sub.increase();
			sub.printI();
		}
	}
}
class Base{
	private int i=100;
	public void printI(){
		System.out.println(this.i);
		System.out.println("do nothing");
	}
	public final void increase(){
		this.i++;
	}
	public int getI(){
		return this.i;
	}
}
