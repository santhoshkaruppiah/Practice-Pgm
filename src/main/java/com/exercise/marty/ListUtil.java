package com.exercise.marty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListUtil {

	public static void main(String[] args) {
		System.out.println(lastEntry(getStringList()));
		System.out.println(lastEntry(getCircleList()));
		
		System.out.println(lastEntry(getStringList().stream()));
		System.out.println(lastEntry(getCircleList().stream()));
	}
	
	/**
	 * Sol. to get lastEntry given any List of object
	 * 
	 * @param list
	 * @return
	 */
	public static <T> T lastEntry(List<T> list) {
		return (list.get(list.size()-1));
	}
	
	/**
	 * Sol. to get lastEntry given any array of Object (list and array for example) 
	 * @param streams
	 * @return
	 */
	public static <T> T lastEntry(Stream<T> streams){
		return (streams.reduce((a, b) -> b).get());
	}
	
	public static List<String> getStringList(){
		 List<String> stringList = new ArrayList<>();
		 stringList.add("AS");
		 stringList.add("fd");
		 return (stringList);
	}
	
	public static List<Circle> getCircleList(){
		 List<Circle> stringList = new ArrayList<>();
		 stringList.add(new Circle(12));
		 stringList.add(new Circle(43));
		 return (stringList);
	}
	
	static class Circle {
		int radius;
		Circle(int radius) {
			this.radius = radius;
		}
		
		public String toString(){
			return String.valueOf(radius);
		}
	}
}
