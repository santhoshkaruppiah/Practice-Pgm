package com.test;

public class TestArrSum {

	public static void main(String[] args) {
		int[] s={7,9,3,4,5};
		System.out.println(doIntegerSumExist(s,14));
	}
	
	public static boolean doIntegerSumExist(int[] arr,int sum){
		
		for(int i=0;i<arr.length;i++){
			int temp=arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (sum==temp+arr[j]){return true;}
			}
		}
		return false;
	}
}
