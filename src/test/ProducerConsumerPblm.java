package test;

import java.util.concurrent.Semaphore;

public class ProducerConsumerPblm {

	static Semaphore producerSema = new Semaphore(1);//start unlocked
	static Semaphore consumerSema = new Semaphore(0);//start locked
	static int iteration = 10;
	
	public static void main(String[] args) {
		Consumer consumer = new Consumer(consumerSema,producerSema,iteration);//Order in which we is Key/important
		Producer producer = new Producer(producerSema,consumerSema,iteration);//Order in which we is Key/important
		
		Thread producerTherad = new Thread(producer,"Producer Thread");
		Thread consumerTherad = new Thread(consumer,"Consumer Thread");
		consumerTherad.start();
		producerTherad.start();
		
		
	}
	
}


class Producer implements Runnable{
	
	Semaphore producerSema;
	Semaphore consumerSema;
	int iteration;
	
	Producer(Semaphore mine, Semaphore other, int iteration){
		this.producerSema = mine;
		this.consumerSema = other;
		this.iteration = iteration;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < iteration; i++) {
			producerSema.acquireUninterruptibly();
			System.out.println(Thread.currentThread().getName()+"-Produce-"+i);
			consumerSema.release();
		}
	}
}


class Consumer implements Runnable{
	
	Semaphore producerSema;
	Semaphore consumerSema;
	int iteration;
	
	Consumer(Semaphore mine, Semaphore other, int iteration){
		this.consumerSema = mine;
		this.producerSema = other;
		this.iteration = iteration;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < iteration; i++) {
			consumerSema.acquireUninterruptibly();
			System.out.println(Thread.currentThread().getName()+"-Consume-"+i);
			producerSema.release();
		}
	}
}