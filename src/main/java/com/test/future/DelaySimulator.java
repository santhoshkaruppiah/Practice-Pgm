package com.test.future;

import java.util.Random;

public class DelaySimulator {

	public static boolean put() throws InterruptedException{
		Thread.sleep(1000);
		return (new Random().nextBoolean());
	}
}
