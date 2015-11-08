package com.thread;

public class TestSync {

	public static void main(String[] args) {
		//SimpleObject obj = new SimpleObject();
		Thread one = new Thread(()->{
			try {
				StaticSimpleObject.doSomething();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		Thread two = new Thread(()->{
			try {
				StaticSimpleObject.doSomethingElse();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		one.start();
		two.start();
	}
}

class SimpleObject {
	
	public synchronized void doSomething() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			System.out.println("doSomething");
			//Thread.sleep(1000l);
			wait(1000l);
		}
	}
	
	public synchronized void doSomethingElse() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			System.out.println("doSomethingElse");
			//Thread.sleep(1000l);
			wait(1000l);
		}
	}
}

class StaticSimpleObject {
	
	private StaticSimpleObject(){}
	
	static StaticSimpleObject instance = new StaticSimpleObject();
	
	static StaticSimpleObject getInstance(){
		return (instance);
	} 
	
	public static synchronized void doSomething() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			System.out.println("doSomething");
			//Thread.sleep(1000l);
			getInstance().wait(1000l);
		}
	}
	
	public static synchronized void doSomethingElse() throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			System.out.println("doSomethingElse");
			//Thread.sleep(1000l);
			getInstance().wait(1000l);
		}
	}
}