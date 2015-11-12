package com.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Grouping {

	public static <K, V> Map<String, List<V>> group(List<V> list) {

		// used for indexing 
		HashMap<String, String> index = new HashMap<String, String>();
		// the container for grouped data
		HashMap<String, List<V>> groupedData = new HashMap<String, List<V>>();

		// the method to invoke to get the value of the 'field' prop from
		Method m = null;

		try {
			V obj = list.get(0);
			m = obj.getClass().getDeclaredMethod(
					"getCustomerSelectedShipMethod", null);
			// m.setAccessible(true);
		} catch (NoSuchMethodException ex) {

			return null;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// iterate through the list of objects passed as parameter
		for (V object : list) {
			// the 'field' value of object
			String columnVal = null;
			try {
				columnVal = (String) m.invoke(object, null);
				// group of objects under columnVal group
				List<V> group = groupedData
						.get(index.get(columnVal.toString()));
				if (group == null) {
					group = new ArrayList<V>();
					groupedData.put(columnVal, group);
					index.put(columnVal.toString(), columnVal);
				}
				// add the object to the group
				group.add(object);
			} catch (Exception ex) {
				// TODO
			}
		}

		return groupedData;

	}
	
	public static void printGroupedSize(Map<String,List<LineItem>> groupedMap){
		System.out.println("groupedMap Size="+groupedMap.size());
		System.out.println("Key Set Count="+groupedMap.keySet().toString());
		String values="";
		Set<String> keyValues = groupedMap.keySet();
		for (String string : keyValues) {
			System.out.println("Customer Selected Ship Method Type is "+string+", and the count is="+groupedMap.get(string).size());
		}

	}
	
}

