package cn.xwb.test;

class ThreadTest1 extends Thread  {
	private String threadName;
	
	
	public ThreadTest1(String threadName) {
		super();
		this.threadName = threadName;
	}
    @Override
	public void run() {
		System.out.println("Running " +  threadName );
	      try {
	         for(int i = 4; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // 让线程睡眠一会
	            Thread.sleep(50);
	         }
	      }catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");
	}
    

}
public class ThreadTest{
	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1("我是第一个");
		t1.start();
		ThreadTest1 t2 = new ThreadTest1("我是第二个");
		t2.start();
		System.out.println("ming"+t1.getName());
		
		System.out.println();
		
		
	}
	
}