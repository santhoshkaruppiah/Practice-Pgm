package com.test;


public class ThreadTest {
	
	public static void main(String[] args) {
		Task tt = new Task();
		for (int i=0;i<5;i++){
			Thread t =new Thread( new Worker(tt));
			t.setName("Thread-"+i);
			t.start();
		}
	}
}

class Worker implements Runnable{
	//public static  int sum = 0;
	Task t;
	public Worker(Object s){
		this.t= (Task)s;
	}
	
	public void run() {
		System.out.println("Thread invoked, name="+Thread.currentThread().getName());
		synchronized (t) {
			try {
				//t.wait(100);
				t.sum +=t.add();
				//Thread.currentThread().join(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		t.sum +=t.add();
//		try {
//			Thread.currentThread().join(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("End Task, sum="+t.sum );
	}
}

class Task {
	
	public  int idx = 1;
	public  int sum=0;
	public   int add(){
		int i= 1;
		int b=1;
		//Thread.yield();
		//synchronized (this) {
			for(;true;i++){
				b = idx+i;
				if (i==5) 
					break;
			}
			idx++;
		//}
		
		System.out.println("b Value="+b+",Thread-Name="+Thread.currentThread().getName());
		return b;
	}
	
}

/*
 * 
  public class ThreadTest {
	
	public static void main(String[] args) {
		for (int i=0;i<5;i++){
			Thread t =new Thread( new Worker());
			t.setName("Thread-"+i);
			t.start();
		}
	}
}
class Worker implements Runnable{
	//public static volatile  int sum = 0;
	
	public void run() {
		System.out.println("Thread invoked, name="+Thread.currentThread().getName());
		synchronized (Task.class) {
			try {
				//t.wait(100);
				Task.sum +=Task.add();
				Thread.currentThread().join(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		sum +=t.add();
//		try {
//			Thread.currentThread().join(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println("End Task, sum="+Task.sum );
	}
}

class Task {
	
	public static int idx = 1;
	public static int sum=0;
	public static  int add(){
		int i= 1;
		int b=1;
		Thread.yield();
		for(;true;i++){
			b = idx+i;
			if (i==5) break;
		}
		idx++;
		System.out.println("b Value="+b+",Thread Name="+Thread.currentThread().getName());
		return b;
	}
	
}*/


