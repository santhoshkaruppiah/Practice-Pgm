package com.test;

import java.util.Stack;

public class StackThread {
	static Stack stkOsbj = new Stack();

	public static void main(String[] args) {
		
		try{
		Thread th1 =new Thread(new WorkerThe(stkOsbj),"pushthread");
		Thread th2 =new Thread(new WorkerThe(stkOsbj),"popthread");
		
		th1.start();
		th2.start();
		//th2.sleep(50);
		th1.join();
		synchronized (stkOsbj) {
			stkOsbj.notify();
		}
		//th2.join();
		System.out.println("Thread Name="+Thread.currentThread().getName()+",stkOsbj-size="+stkOsbj.size());
		while(th1.isAlive()){
			System.out.print("pushthread is active--");
		}
		while(th2.isAlive()){
			System.out.print("popthread is active--");
		}
		System.out.println("\n End of ALL");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class WorkerThe implements Runnable{
	
	Stack stkOsbj;
	public WorkerThe(Stack stkOsbj){
		this.stkOsbj = stkOsbj;
	}
	
	public void run() {
		//System.out.println("Name::"+Thread.currentThread().getName());
		if (Thread.currentThread().getName().equals("pushthread")) {
			for (int i = 1; i <=5; i++) {
				synchronized (stkOsbj) {
					//System.out.println("Stack Push--START"+",stack size="+stkOsbj.size());
					stkOsbj.push(i);
					System.out.println("Stack-push--Data Pushed, val="+i);
					//Thread.currentThread().notifyAll();
					stkOsbj.notifyAll();
					//System.out.println("Stack-push--notifyAll");
					try {
						//Thread.currentThread().wait();
						//System.out.println("Stack-push--DO wait");
						stkOsbj.wait();
						//System.out.println("Stack-push--wait ended");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//System.out.println("Stack Push--END");
				}//end synch
			}//end for
		}//if end thread name check
		
		
		if (Thread.currentThread().getName().equals("popthread") && stkOsbj.size()>0) {
			for (int i = 1; i <=5; i++) {
				synchronized (stkOsbj) {
					//System.out.println("Stack POP--START"+",stack size="+stkOsbj.size());
	//				try {
	//						//Thread.currentThread().wait();
	//						stkOsbj.wait();
	//						System.out.println("Stack POP--Wait");
	//				} catch (InterruptedException e) {
	//					e.printStackTrace();
	//				}
					
					System.out.println("Stack POP--POPPED--Val="+stkOsbj.pop());
					//Thread.currentThread().notifyAll();
					stkOsbj.notifyAll();
					//System.out.println("Stack POP--NOTIFY ALL");
					try{
						stkOsbj.wait();
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
					//System.out.println("Stack POP--END");
				}//end synch
			}//end for loop
		}
		
	}
	
}