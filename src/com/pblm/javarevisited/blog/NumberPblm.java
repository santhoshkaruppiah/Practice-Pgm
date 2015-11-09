package com.pblm.javarevisited.blog;

public class NumberPblm {

	public static final int reverseNumber(int number){
		if (number<10) return number;
		int reverseNumber=0;
		int remainder=0;
		do{
			remainder=number%10;
			reverseNumber=reverseNumber*10+remainder;
			number=number/10;
		}while(number>0) ;
		return reverseNumber;
	}
	
	public static void main(String[] args) {
		
	}
}
