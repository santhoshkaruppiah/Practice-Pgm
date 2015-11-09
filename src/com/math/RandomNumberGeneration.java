package com.math;

public class RandomNumberGeneration {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println("i="+i+", shifted valu= "+xorShift(i)+", length= "+(1 + (int)Math.floor(Math.log10(xorShift(i)))));
		}
	}
	
	public static int xorShift(int y) { 
		y ^= (y << 6); 
		y ^= (y >>> 21); 
		y ^= (y << 7); 
		return y; 
	}
}
