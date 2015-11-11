package com.test;

import java.util.Arrays;

public class SwapWithNoTempVar {
	
	public static void main(String[] args) {
		
		//int[] s= {9,4,8,2};
		//String[] s= {"CAT","DOG","FISH","LION"};
		char[] s={'d','x','s','r'};
		System.out.println("Before swapping");
		System.out.println(Arrays.toString(s));
		s[0] ^=s[1];
		s[1] ^=s[0];
		s[0] ^=s[1];
		System.out.println("After swapping");
		System.out.println(Arrays.toString(s));
	}
}
