import test1.Base;


public class NotOverriding extends Base{
	int i=2;
	public static void main(String[] args){
		NotOverriding no=new NotOverriding();
//		no.increase();
		System.out.println(no.i);
//		System.out.println(no.getI());
		
		Base no1=new NotOverriding();
		System.out.println(no1.i);
	}
}

class Base{
	int i=100;
	public void increase(){
		this.i++;
	}
	public int getI(){
		return this.i;
	}
}