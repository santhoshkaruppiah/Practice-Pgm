package com.math;

public class PrimeSeries {

	public static boolean isPrime(int num){
		if (num<2) return false;
		if (num==2) return true;
		 for(int i=2;i<=(int)Math.sqrt(num)+1;i++){ //loops through 2 to sqrt(num). 
		      if(num%i==0){ //if a divisor is found, its not prime. returns false
		        return(false);
		      }
		    }
		return true;
	}
	
}
