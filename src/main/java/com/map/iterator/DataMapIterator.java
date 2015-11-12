package com.map.iterator;

import java.util.Map;

public abstract class DataMapIterator  {

	Map<String, Object> data;
	Map<String,Object> context;
	
	void init (Map<String, Object> data) {
		this.data = data;
		this.context = (Map<String,Object>)data.get("CONTEXT");
	}

	protected String context(){
		StringBuffer sb = new StringBuffer();
		sb.append(context.get("s.org"));
		sb.append(context.get("ccg"));
		return (sb.toString());
	}

}
