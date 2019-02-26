class T1 {
	static int s1 = 1;
	static { System.out.println("static block of T1: " + T3.s3); }
	T1() { System.out.println("T1(): " + s1); }
}

class T2 extends T1 {
	static int s2 = 2;
	static { System.out.println("static block of T2: " + T3.s3); }
	T2() { System.out.println("T2(): " + s2); }
}

public class T3 extends T2 {
	static int s3 = 3;
	static { System.out.println("static block of T3: " + T3.s3); }
	T3() { System.out.println("T3(): " + s3); }
	public static void main(String[] args) {
		new T3();
	}
}
