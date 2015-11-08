package com.test.future;

import java.util.Map;
import java.util.concurrent.Callable;

class PCICache implements   Callable<PCICache> {

	private Map<String,Object> dataMap;
	
	PCICache(Map<String,Object> dataMap){
		this.dataMap = dataMap;
	}
	
	@Override
	public PCICache call() throws Exception {
		boolean result = DelaySimulator.put();
		System.out.println("PCICache="+result);
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
