package com.test;

public class TestFibn {

	public static int rec_fin(int n){
		if (n==0 || n==1) {return n;}
		else{
			return rec_fin(n-1)+rec_fin(n-2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(rec_fin(10));
	}
}
