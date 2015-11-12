package com.chain;

import java.util.HashMap;
import java.util.Map;

public class ChainThree extends AbstractChain {

	@Override
	protected Map<String, String> partProcess(String req,Map<String, String> resultMap) {
		System.out.println("Chain-3");
		return new HashMap<String,String>();
	}

}
