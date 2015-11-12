package com.chain;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractChain {

	protected AbstractChain successor;
	
	protected boolean canHandle = true;
	
	public void setSuccessor(AbstractChain successor){
		this.successor = successor;
	}
	
	public AbstractChain getSuccessor(){
		return (this.successor);
	}
	
	protected abstract Map<String,String> partProcess(String req,Map<String,String> resultMap);
	
	public final Map<String,String> handleRequest(String req){
		Map<String,String> resultMap = new HashMap<String,String>();
		try{
			Map<String,String> result = this.partProcess(req,resultMap);
		}catch(Exception s){
			System.out.println(s);
		}
		
		if (successor!=null)
			successor.handleRequest(req);
		
		return (resultMap);
	}
}
