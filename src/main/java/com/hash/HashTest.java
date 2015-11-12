package com.hash;

public class HashTest {

	public static void main(String[] args) {
		
		printHashCode(new Object());
		printHashCode("san");
		printHashCode(new String("san"));
	}
	
	public static void printHashCode(Object o){
		System.out.println("Standard hashcode ="+o.hashCode());
		System.out.println("Identity hashcode ="+System.identityHashCode(o));
	}
}
