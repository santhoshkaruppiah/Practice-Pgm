package com.math;

public class MathUtil {

	public static final boolean isPowerOf2(int toFind){
		if (toFind<2) return false;
		int last=0;
		while(toFind>1){
			last=toFind;
			toFind=toFind/2;
			if (last%2!=0){break;}

		}
		//System.out.println("last="+last+",toFind="+toFind);
		return (toFind+toFind==last);
		
	}
	
	public static final boolean isPower2(int toFind){
		return (toFind &(toFind-1))==0;
	}
	
	public static void main(String[] args) {
		System.out.println("Method=isPowerOf2()");
		System.out.println("4 is Power of 2::"+isPowerOf2(4));
		System.out.println("0 is Power of 2::"+isPowerOf2(0));
		System.out.println("3 is Power of 2::"+isPowerOf2(3));
		System.out.println("32 is Power of 2::"+isPowerOf2(32));
		System.out.println("2 is Power of 2::"+isPowerOf2(2));
		System.out.println("Method=isPower2()");
		System.out.println("4 is Power of 2::"+isPower2(4));
		System.out.println("0 is Power of 2::"+isPower2(0));
		System.out.println("3 is Power of 2::"+isPower2(3));
		System.out.println("32 is Power of 2::"+isPower2(32));
		System.out.println("2 is Power of 2::"+isPower2(2));
	}
}
