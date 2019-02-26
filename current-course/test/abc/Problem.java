package abc;

public class Problem {
	
	public Object makeInner(final int i){
		int k=4;
		class Inner1{
			public String toString(){
				//k=5;
				return "Inner1 "+(i+k);//课本上说：不能访问方法中的非final局部变量，但此处不会出错，这是为什么？
				}
		}
		return new Inner1();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem cs=new Problem();
		Object obj=cs.makeInner(5);
		System.out.println(obj.toString());

	}

}
