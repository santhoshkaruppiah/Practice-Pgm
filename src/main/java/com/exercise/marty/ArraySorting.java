package com.exercise.marty;

import java.util.Arrays;
import java.util.Comparator;

/**
 * All array sorting exercise sol, without lamda 
 *
 */
public class ArraySorting {

	public static void main(String[] args) {
		String[] input =new String[]{"sknf","nv","aldjnlf","err","cn","ab","eff"};
		System.out.println(Arrays.asList(lengthSort(input)));
		System.out.println(Arrays.asList(reverseLengthSort(input)));
		System.out.println(Arrays.asList(zeroIndexSort(input)));
		System.out.println(Arrays.asList(stringContentSort(input)));
		System.out.println(Arrays.asList(stringContentSortV2(input)));
	}
	
	public static <T extends Comparable<T>> T[] lengthSort(T[] toSort) {
		
		Arrays.sort(toSort, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				String param1=(String)o1;
				String param2=(String)o2;
				int status=-3;
				if (param1.length()<param2.length()){
					status=-1;
				}else if(param1.length()==param2.length()) {
					status=0;
				}else if (param1.length()>param2.length()){
					status=1;
				}
				return status;
			}
		});
		
		return toSort; 
	}
	
	public static <T extends Comparable<T>> T[] reverseLengthSort(T[] toSort) {
		
		Arrays.sort(toSort, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				String param1=(String)o1;
				String param2=(String)o2;
				int status=-3;
				if (param1.length()<param2.length()){
					status=1;
				}else if(param1.length()==param2.length()) {
					status=0;
				}else if (param1.length()>param2.length()){
					status=-1;
				}
				return status;
			}
		});
		
		return toSort; 
	}
	
	public static <T extends Comparable<T>> T[] zeroIndexSort(T[] toSort) {
		
		Arrays.sort(toSort, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				String param1=(String)o1;
				String param2=(String)o2;
				int status=-3;
				if (param1.charAt(0)<param2.charAt(0)){
					status=-1;
				}else if(param1.charAt(0)==param2.charAt(0)) {
					status=0;
				}else if (param1.charAt(0)>param2.charAt(0)){
					status=1;
				}
				return status;
			}
		});
		
		return toSort; 
	}
	
	public static <T extends Comparable<T>> T[] stringContentSort(T[] toSort) {
		
		Arrays.sort(toSort, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				String param1=(String)o1;
				String param2=(String)o2;
				int status=-3;
				if (param1.contains("e") && param2.contains("e")){
					status=1;
				}else if(param1.contains("e") || param2.contains("e")) {
					status=-1;
				}else {
					status=0;
				}
				return status;
			}
		});
		
		return toSort; 
	}
	
	public static <T extends Comparable<T>> T[] stringContentSortV2(T[] toSort) {
		
		Arrays.sort(toSort, new Comparator<T>() {
			@Override
			public int compare(T o1, T o2) {
				String param1=(String)o1;
				String param2=(String)o2;
				return eChecker(param1, param2);
			}
		});
		
		return toSort; 
	}
	
	public static int eChecker(String param1, String param2) {
		int status;
		if (param1.contains("e") && param2.contains("e")){
			status=1;
		}else if(param1.contains("e") || param2.contains("e")) {
			status=-1;
		}else {
			status=0;
		}
		return status;
	}
}

