package test;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeTaskTest {

	Timer timer;
	AtomicInteger atomicInt = new AtomicInteger(1);
	
    public TimeTaskTest(int seconds) {
        timer = new Timer("TimerTask-HostStatus",true);
//        for (int i=1;i<100;i++) {
//        timer.schedule(new RemindTask(), seconds*1000);
//        timer.schedule(new RemindTask(), seconds*1000);
//        timer.schedule(new RemindTask(), seconds*1000);
//        }
	}

    class RemindTask extends TimerTask {
    	
        public void run() {
            System.out.println("Time's up!-"+atomicInt.incrementAndGet());
            //timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        new TimeTaskTest(1);
        try {
			Thread.currentThread().sleep(10000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.format("Task scheduled.%n");
    }
}
