package com.math;

public class FibnocciSol {

	public static final int fibSol1(int num){
		if (num==0 || num==1) {return (num);}
		return fibSol1(num-1)+fibSol1(num-2);
	}
	
	public static final int fibSol3(int num){
		if (num==0) return 0;
		if (num==1 || num==2) return 1;
		int[] fibCache=new int[num+1];
		fibCache[0]=0;
		fibCache[1]=1;
		fibCache[2]=1;
		int result=0;
		for (int i=3;i<=num;i++){
			fibCache[i]=fibCache[i-2]+fibCache[i-1];
			result=fibCache[i];
		}
		return result;
	}
	
}
