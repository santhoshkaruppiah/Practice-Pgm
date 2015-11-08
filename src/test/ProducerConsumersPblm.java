package test;


public class ProducerConsumersPblm {

	
	public static void main(String[] args) {
		Buffer obj = new Buffer();
		Thread prod= new Thread(new Producer1(obj));
		prod.setName("Producer1-Therad");
		Thread consu1= new Thread(new Consumers(obj));
		consu1.setName("Consumers1-Therad");
		Thread consu2= new Thread(new Consumers(obj));
		consu2.setName("Consumers2-Therad");
		
		prod.start();
		
		consu1.start();
		
//		consu2.start();
	}
	
}


class Buffer {
	
	private boolean occupied = false;
	private int buffer = -1;
	
	public synchronized int get() {
		
		while(!occupied) {
			try {
				System.out.println(Thread.currentThread().getName()+" ,waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		occupied = false;
		notifyAll();
		return buffer;
	}
	
	public synchronized void set(int value) {
		
		while(occupied){
			try {
				System.out.println(Thread.currentThread().getName()+" ,waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		buffer = value;
		occupied = true;
		notifyAll();
	}
}

class Producer1 implements Runnable {
	
	Buffer ref;
	
	Producer1(Buffer ref){
		this.ref = ref;
	}
	
	public void run(){
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			ref.set(i);
		}
	}
}

class Consumers implements Runnable {
	
	Buffer ref;
	
	Consumers(Buffer ref){
		this.ref = ref;
	}
	
	public void run(){
		
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}
