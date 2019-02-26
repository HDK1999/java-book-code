package test1;

public class MyThread{
	public static void main(String[] args){
		Thread t=new Proc();
		t.start();
		try{
			Thread.sleep(1000);
			t.join();
			System.out.println("super");
			
		} catch (Exception e){}
	}
}

class Proc extends Thread{
	public void run(){
		System.out.println("sub");
	}
}