class MyException1 extends Exception{
	
}
class MyException2 extends Exception{
	
}

public class Test3{
	public static void mtd() throws MyException2{
		System.out.println("s2");
		throw new MyException2();
	}
	public static void main(String[] args) throws Exception{
		try {
			System.out.println("s1");
			mtd();
			System.out.println("s3");
		}catch(MyException2 e){
			System.out.println("s4");
			throw new MyException1();
		} finally {
			System.out.println("s5");
		}
		System.out.println("s6");
    }
}