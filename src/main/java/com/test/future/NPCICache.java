package com.test.future;

import java.util.Map;
import java.util.concurrent.Callable;

public class NPCICache implements  Callable<NPCICache> {

	private Map<String,Object> dataMap;
	
	NPCICache(Map<String,Object> dataMap) {
		this.dataMap = dataMap;
	}
	
	@Override
	public NPCICache call() throws Exception {
		boolean result = DelaySimulator.put();
		System.out.println("NPCICache="+result);
		if (!result){
			return this;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return dataMap.toString();
	}
}
