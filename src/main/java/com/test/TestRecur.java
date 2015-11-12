package com.test;

public class TestRecur {
	static int result;
	public static int recur_rec(int toCompute){
		if (toCompute==1) return 1;
		result = toCompute*recur_rec(toCompute-1);
		return result;
	}
	
	public static void main(String[] args) {
		TestRecur obj=new TestRecur();
		System.out.println(obj.recur_rec(8));
	}
}
