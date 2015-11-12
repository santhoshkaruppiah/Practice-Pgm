package test;

public class BusyWait {

	public static void main(String[] args) {
		Thread th1=new Thread(new RunnableDemoBusyWait());
		th1.start();
	}
	
}

class RunnableDemoBusyWait implements Runnable {
	DemoBusyWait DemoBusyWaitobj = new DemoBusyWait();
	
	public void run(){
		for (int i = 0; i < 4; i++) {
			DemoBusyWaitobj.method1();	
			DemoBusyWaitobj.method2();	
		}
	}
}

class DemoBusyWait {
	
	public synchronized void method1(){
			if (1!=0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println("do nothing");
			}	
	}
	
	public synchronized void method2(){
		notifyAll();
	}
	
}