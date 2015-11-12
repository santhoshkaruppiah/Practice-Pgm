package com.debug;

public class ExpTest {

	public static void main(String[] args) {
		System.out.println(test(1,2));
		System.out.println(test(0,2));
		System.out.println(test(2,2));
		System.out.println(test(2,0));
	}
	
	public static boolean test(int one,int two) {
		return((!(one==0) && (one==two)));
	}
}
