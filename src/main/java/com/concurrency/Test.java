package com.concurrency;
/**
 * 
 * @author santhosh
 * This code may cause Deadlock, please analyse and keep for experimenting
 */
public class Test {

private static int count = 0;

public static void main(String[] args) throws InterruptedException {

    Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {

            for (int i = 0; i < 25; i++) {
                synchronized (CommonUtil.mLock) {
                    incrementCount();
                    CommonUtil.mLock.notify();
                    try {
                        CommonUtil.mLock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    });
    Thread t2 = new Thread(new Runnable() {

        @Override
        public void run() {

            for (int i = 0; i < 25; i++) {
                synchronized (CommonUtil.mLock) {
                    incrementCount();
                    CommonUtil.mLock.notify();
                    try {
                        CommonUtil.mLock.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    });
    t1.setName("santhosh");
    t2.setName("babu");
    t1.start();
    Thread.sleep(400);
    t2.start();
    t1.join();
    t2.join();
}

private static void incrementCount() {

    count++;
    System.out.println("Count: " + count + " icnremented by: " +        Thread.currentThread().getName());
}
}
  class CommonUtil {

 static final Object mLock = new Object();
   }