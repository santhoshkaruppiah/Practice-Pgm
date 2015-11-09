package com.concurrency;

public class Consumers {

	public static void main(String[] args) {
		try {
			Tasks runnable=new Tasks(); 
			Thread th1=new Thread(runnable);
			Thread th2=new Thread(runnable);
			th1.start();
			th2.start();
//			th1.join();
//			th2.notify();
//			th1.notify();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
