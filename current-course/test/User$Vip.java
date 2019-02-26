public class User$Vip{
	public static void main(String[] args){
		int i=10;
		User$Vip.test(i,++i,i=2);
		User$Vip.test(i=5,i++,i);
	}
	public static void test(int x,int y,int z){
		System.out.println(x+";"+y+";"+z);
	}
}
/*class User{
	class Vip{
		void print(){
			System.out.println("ÄÚ²¿Àà");
		}
	}
}*/