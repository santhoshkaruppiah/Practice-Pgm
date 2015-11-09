package com.tricks;

import java.util.Arrays;

public class SwapWithoutBuffer {

	public static final void swapDemo(){
		char[] s={'d','x','s','r'};
		System.out.println("Before swapping");
		System.out.println(Arrays.toString(s));
		s[0] ^=s[1];
		s[1] ^=s[0];
		s[0] ^=s[1];
		System.out.println("After swapping");
		System.out.println(Arrays.toString(s));
	}
	
	public static final String reverseRecurXOR(String inStr, int start, int end){
		if (inStr==null || inStr.length()<=1) return inStr;
		char[] tempArr=inStr.toCharArray();
		//int start=0;
		//int end=tempArr.length-1;
		while(start<=end){
			tempArr[start]^=tempArr[end];
			tempArr[end]^=tempArr[start];
			tempArr[start]^=tempArr[end];
			start++;
			end--;
		}
		return Arrays.toString(tempArr);
	}
	
	public static final String rotateStr(String inStr,int rotateBy){
		if (inStr==null || inStr.length()<=1) return inStr;
		int len = inStr.length();
		/*Rotating a string by it's length is string itself.*/
		 rotateBy %= len;
		 reverseRecurXOR(inStr, 0, len-1);
		 reverseRecurXOR(inStr, 0, rotateBy-1);
		 reverseRecurXOR(inStr, rotateBy, len-1);
		 return inStr;
	}
	public static void main(String[] args) {
		SwapWithoutBuffer.swapDemo();
		System.out.println(SwapWithoutBuffer.reverseRecurXOR("santhosh",0,"santhosh".length()-1));
		System.out.println(SwapWithoutBuffer.rotateStr("santhosh",2));
	}
}
