class MyThread extends Thread{
	static int thread_count=1;
	
	int thread_id=thread_count++;
	private MyThread wait_target=null;
	
	public MyThread(){ }
	public MyThread(MyThread target){
		wait_target=target;
	}
	public void run(){
		try {
			if(wait_target==null){
				Thread.sleep(1000);
				System.out.println("thread_id: "+this.thread_id);
			}
			else {
				Thread.sleep(1000*thread_id);
				wait_target.join();
				System.out.println("thread_id: "+this.thread_id);
			}
		} catch (InterruptedException e){
		}
	}
}

public class Test7{
	public static void main(String[] args) throws Exception{
		MyThread t1=new MyThread();
		MyThread t2=new MyThread(t1);
		MyThread t3=new MyThread(t2);
		MyThread t4=new MyThread();
		t4.start();
		Thread.sleep(1000);
		t3.start();
		t2.start();
		t1.start();
	}
}