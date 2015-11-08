package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

public class MapTest {

	public static void main(String[] args) {
		//printMap();
//		emptyTest();
//		testMultiMap();
//		printHashMapTest();
//		printSubMap();
//		google_guava_range_map_example();
		google_guava_range_map();
	}
	
	static void google_guava_range_map_example () {

	    RangeMap<Integer, String> gradeScale = TreeRangeMap.create();
	    gradeScale.put(Range.closed(0, 60), "F");
	    gradeScale.put(Range.closed(61, 70), "D");
	    gradeScale.put(Range.closed(71, 80), "C");
	    gradeScale.put(Range.closed(81, 90), "B");
	    gradeScale.put(Range.closed(91, 100), "A");
	    String grade = gradeScale.get(77);
	    System.out.println(grade);
	}
	
	static void google_guava_range_map(){
		List<String> stringKeys = new ArrayList<>();
		stringKeys.add("A");
		stringKeys.add("Z");
		stringKeys.add("k");
		stringKeys.add("o");
		System.out.println(stringKeys.subList(1, 3));
		System.out.println(com.google.common.collect.Lists.partition(stringKeys, 3));
		List<List<String>> ref = com.google.common.collect.Lists.partition(stringKeys, 3);
	}
	
	static void printSubMap(){
		SortedMap<String,String> printMap = new TreeMap<>();
		printMap.put("Key1", "Val1");
		printMap.put("Key2", "Val2");
		printMap.put("Key3", "Val3");
		printMap.put("Key5", "Val5");
		printMap.put("Key7", "Val7");
		printMap.put("Key6", "Val6");
		printMap.put("Key8", "Val8");
		printMap.put("Key4", "Val4");
		
		System.out.println(printMap);
		System.out.println("SubMap=="+printMap.subMap("Key2","Key9"));
	}
	
	static void printMap(){
		Map<String,String> printMap = new HashMap<>();
		System.out.println(printMap);
		List<String> strList = new ArrayList<String>();
		strList.add("asdasdc12");
		strList.add("asdasdc34");
		strList.add("aoojdasdc34");
		List<String> str_List = new ArrayList<String>();
		str_List.add("2asdasdc12");
		str_List.add("2asdasdc34");
		str_List.add("2aoojdasdc34");
		printMap.put("PCI-LIST", strList.toString());
		printMap.put("NON-PCI-LIST", str_List.toString());
		System.out.println(printMap);
		System.out.println(strList.toString());
		System.out.println(str_List.toString());
		
	}
	
	static void printHashMapTest() {
		Map<String,String> printMap = new HashMap<>();
		printMap.put("PCI-LIST", "ad");
		printMap.put("PCI-LIST", "sd");
		printMap.put("NON-PCI-LIST", "vc");
		System.out.println(printMap);
		System.out.println("Entry set="+printMap.entrySet());
		System.out.println("Values="+printMap.values());
		for (Map.Entry<String, String> iterable_element : printMap.entrySet()) {
		}
	}
	
	static void emptyTest(){
		System.out.println("Map-Test");
		System.out.println(Collections.emptyMap());
		System.out.println(Collections.emptyMap()==null);
		System.out.println(Collections.emptyMap().size());
		
		System.out.println("List-Test");
		System.out.println(Collections.emptyList());
		System.out.println(Collections.emptyList()==null);
		System.out.println(Collections.emptyList().size());
	}
	
	static void testMultiMap(){
		
		//Multimap<String, String> myMultimap = ArrayListMultimap.create();
		Multimap<String, String> myMultimap = null;
		ImmutableListMultimap.Builder<String,String> builder=ImmutableListMultimap.builder();
		  // Adding some key/value
//		  myMultimap.put("Fruits", "Bannana");
//		  myMultimap.put("Fruits", "Apple");
//		  myMultimap.put("Fruits", "Pear");
//		  myMultimap.put("Vegetables", "Carrot");
		  
		  builder.put("Fruits", "Bannana");
		  builder.put("Fruits", "Apple");
		  builder.put("Fruits", "Pear");
		  builder.put("Vegetables", "Carrot");
		  myMultimap=  builder.build();
		  
		  System.out.println("myMultimap="+myMultimap);
		  System.out.println("myMultimap="+myMultimap.toString());
	}
}
