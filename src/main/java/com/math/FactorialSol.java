package com.math;

public class FactorialSol {
	
	/**
	 * 
	 * 5! = 5*4*3*2*1 = 120.  
	 * The factorial function is formally defined by the product
 			n!=\prod_{k=1}^n k \!
	   OR by the recurrence relation
 			n! = 1 		if n = 0,
				(n-1)*n if n> 0
	 */
	public static final int factSol1(int num){
		if (num==0) {return 1;}
		return num*(factSol1(num-1));
	}
	
	public static final int factSol2(int num){
		int result=1;
		for (int i=num;i>=1;i--){
			result*=i;
		}
		return result;
	}
	
	
}
