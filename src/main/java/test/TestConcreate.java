package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestConcreate {

	static ExecutorService _WORKERS = Executors.newSingleThreadExecutor();
	
	public static void main(String[] args) {
		Base obj = new Concreate();
		Base obj2 = new Concreate2();
		
		obj.method1();
		obj2.method1();
		
		shutdownAndAwaitTermination();
	}
	
	private static final void shutdownAndAwaitTermination(){
		System.out.println("trying..");
		_WORKERS.shutdown();//NOTE: shutdown throw exception
		System.out.println("tried shutdown..");
		try {
			if (!_WORKERS.awaitTermination(100, TimeUnit.MILLISECONDS)) {
				System.out.println("awaitTermination..");
				_WORKERS.shutdownNow(); 
				System.out.println("tried shutdown NOW..");
			if (!_WORKERS.awaitTermination(100, TimeUnit.MILLISECONDS))
				System.out.println("");
			}
		} catch (InterruptedException ie) {
			System.out.println("shutdown excep..");
			_WORKERS.shutdownNow();
		}
	}
		
}
