package com.number;

public class PrintNumberTest {

	public static void main(String[] args) {
		printIntDigit(Integer.MAX_VALUE);
		printIntDigit(Integer.MIN_VALUE);
	}
	
	public static void printIntDigit(int n){
		System.out.println("Oct="+Integer.toString(n,8)+",len="+Integer.toString(n,8).length()); // prints 144 --octal representation

		System.out.println("Binary="+Integer.toString(n,2)+",len="+Integer.toString(n,2).length()); // prints 1100100 --binary representation

		System.out.println("Hex="+Integer.toString(n,16)+",len="+Integer.toString(n,16).length()); //prints 64 --Hex representation
	}
	
}
