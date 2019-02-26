public class Sub extends Super{
	String s="sub";
	public static void main(String[] args){
		Super sup=new Sub();
		System.out.println(sup.s);
	}
}
class Super{
	String s="super";
}