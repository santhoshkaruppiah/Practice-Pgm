package com.map.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class NestedMapIterator {
	
	public static void main(String[] args) {
		List<Map<String,Object>> listOfMap= listOfMap();
		Iterator iter = listOfMap.iterator();
		while (iter.hasNext()) {
			DataSetIterator.getInstance().init((Map<String,Object>)iter.next());
			while (DataSetIterator.getInstance().hasNext()){
				System.out.println(DataSetIterator.getInstance().next());
			}
		}
		
//		Iterator iter = listOfMap.iterator();
//		while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
		
	}
	
	public static List<Map<String,Object>> listOfMap(){
		List<Map<String, Object>> listOfMaps = new ArrayList<>();
		List<String> optionsArray = new ArrayList<String>();
		optionsArray.add("064");
		listOfMaps.add(topMap(dataSetList("MB565",(optionsArray)),contextMap("5600","DS")));
		listOfMaps.add(topMap(dataSetList("MB585",(optionsArray)),contextMap("9600","Si")));
		return listOfMaps;
	}

	private static Map<String,Object> topMap(List<Map<String, Object>> dataSetList,Map<String, Object> contextMap) {
		Map<String, Object> mapOne = new HashMap<>();
		mapOne.put("DATASET", dataSetList);
		mapOne.put("CONTEXT", contextMap);
		return (mapOne);
	}

	private static Map<String, Object> contextMap(String sorg,String ccg) {
		Map<String,Object> contextMap = new HashMap<>();
		contextMap.put("s.org", sorg);
		contextMap.put("ccg", ccg);
		return contextMap;
	}

	private static List<Map<String, Object>> dataSetList(String part,List<String> options) {
		List<Map<String,Object>> dataSetList = new ArrayList<>();
		dataSetList.add(dataMap(part+"--1",options));
		dataSetList.add(dataMap(part+"--2",options));
		return dataSetList;
	}

	private static Map<String,Object> dataMap(String part,List<String> options) {
		Map<String,Object> dataMap = new HashMap<>();
		dataMap.put("PART", part);
		dataMap.put("OPTIONS", options);
		return (dataMap);
	}
	
}

class DataSetIterator extends DataMapIterator implements Iterator {

	private DataSetIterator(){}
	
	private static DataSetIterator instance  = new DataSetIterator();
	
	public static DataSetIterator getInstance(){ return (instance);}

	List<Map<String,Object>> dataset;
	Iterator iter;
	int idx=0;
	
	void init (Map<String,Object> data) {
		super.init(data);
		idx=0;
		this.dataset  = (List<Map<String,Object>>)data.get("DATASET");
		this.iter=dataset.iterator();
	}
	
	@Override
	public boolean hasNext() {
		return (idx<dataset.size());
	}

	@Override
	public String next() {
		Map<String,Object> data = (Map<String,Object>) iter.next();
		String context = context();
		idx++;
		return (concatValues(context,data));
	}
	
	protected String concatValues(String context , Map<String,Object> mapObject){
		StringBuffer sb = new StringBuffer();
		sb.append(context);
		sb.append(mapObject);
		return (sb.toString());
	}
}
