package com.test;

public class SampleREc1 {

	public static int sumN_Number(int n){
		if (n==1){
			System.out.println("n is="+n);
			return 1;
		}else{
			System.out.println("n is="+n);
			return n+sumN_Number(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("End reult ="+SampleREc1.sumN_Number(4));
	}
}
