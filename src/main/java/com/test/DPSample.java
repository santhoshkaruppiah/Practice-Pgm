package com.test;

public class DPSample {

	public static int fib_rec(int i){
		if (i==0) return 0;
		if (i==1) return 1;
		
		return fib_rec(i-1)+fib_rec(i-2);
	}
	
	 int[] fib=new int[100];//init to good number
	public  int fib_dp(int i){
		if (i==0) return 0;
		if (i==1) return 1;
//		for (int val : fib) {
//			System.out.println("fib arr="+val);
//		}
		if (fib[i]!=0) return fib[i];
		fib[i]=fib_rec(i-1)+fib_rec(i-2);
		return fib[i];
	}
	
	
	public static void main(String[] args) {
		DPSample ref=new DPSample();
		System.out.println(ref.fib_dp(10));
		System.out.println(ref.fib_dp(12));
		int i=0;
		for (int val : ref.fib) {
			if (val!=0)
			System.out.println(">>fib arr="+val+",idx="+i);
			i++;
		}
	}
}
