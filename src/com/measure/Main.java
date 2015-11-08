package com.measure;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;

public class Main {

	static Map<String,String> d = new HashMap<String,String>();
	
	public static void main(String[] args) {
		Thread infiniteTherad = new Thread(new LoopRunnable());
		infiniteTherad.setDaemon(false);
		infiniteTherad.start();
		System.out.println("Another Task");
		dumpMap(5);
	}
	
	static void dumpMap(int loopCount){
		
		for (int i = 0; i < loopCount; i++) {
			d.put(RandomStringUtils.randomAlphabetic(24), RandomStringUtils.randomAlphanumeric(50));
		}
		System.out.println("Size="+d.size()+", value="+d);
	}
	
}


class LoopRunnable implements Runnable {

	public void run(){
		for(;;) {
			
		}
	}
}