package com.gayle;

import java.util.Arrays;

public class ArrayMultiplication {

	public static final int[] mulArrays(int[] oneArr,int[] twoArr){
		int[] resultArr=new int[oneArr.length*twoArr.length];
		int resultArrIdx=0;
		for (int i = 0; i < oneArr.length; i++) {
			for (int j = 0; j < twoArr.length; j++) {
				resultArr[resultArrIdx]=oneArr[i]*twoArr[j];
				resultArrIdx++;
			}
		}
		return resultArr;
	}
	
	public static final int[] mulArrays2(int[] oneArr,int[] twoArr){
		int[] resultArr=new int[oneArr.length*twoArr.length];
		int resultArrIdx=0;
		for (int i = 0; i < oneArr.length; i++) {
			for (int j = 0; j < twoArr.length; j++) {
				resultArr[resultArrIdx]=oneArr[i]*twoArr[j];
				resultArrIdx++;
			}
		}
		return resultArr;
	}
	
	public static void main(String[] args) {
		int[] oneArr=new int[]{1,2,3};
		int[] twoArr=new int[]{1,2};
		System.out.println(Arrays.toString(mulArrays(oneArr,twoArr)));
	}
}
