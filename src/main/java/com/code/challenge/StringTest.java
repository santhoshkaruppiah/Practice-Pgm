package com.code.challenge;


public class StringTest {

	public static String reverseString(String toReverse){
		char[] arr = toReverse.toCharArray();
		for (int i=0,j=arr.length-1;i<(arr.length/2);i++,j--) {
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		return (new String(arr));
	}
	
	public static void main(String[] args) {
//		char[] dfn = new char[3];
//		dfn[0]='d';
//		dfn[1]='\u0000' ;
//		dfn[2]='d';
//		System.out.println(new String(dfn));
		
		System.out.println(reverseString("ABCDE"));//Odd len
		System.out.println(reverseString("ABCD"));//even len
	}
}
