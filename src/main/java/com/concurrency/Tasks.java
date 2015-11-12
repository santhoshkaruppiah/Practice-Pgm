package com.concurrency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Tasks implements Runnable {

	
    private final Queue<Integer> queue;
    Tasks(){
    	queue=new LinkedList<Integer>();
    	queue.add(3);
    	queue.add(5);
    	queue.add(1);
    	queue.add(7);
    	queue.add(5);
    	queue.add(9);
    	queue.add(6);
    }
    
	private final Map<String,Integer> threadTaskMap=new HashMap<String,Integer>();
	private final byte[] byteLock=new byte[1];
	@Override
	public void run() {
		try{
		synchronized (byteLock) {
//			threadTaskMap.put(Thread.currentThread().getName(),queue.poll());
//			Thread.currentThread().wait();
			for (int i = 0; i < 5; i++) {
				System.out.println("I="+i+" ,"+Thread.currentThread().getName());
				wait();
			}
		}
		}catch(Exception iExp){
			iExp.printStackTrace();
		}
	}
	
}
