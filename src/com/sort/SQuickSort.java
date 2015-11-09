package com.sort;

import java.util.Arrays;

public class SQuickSort {

	
	//private static int[] unsortedArr= {55,41,59,26,53,58,97,93,52};
	
	public static void quickSortSol1(int[] unsortedArr,int lowBound,int upBound){
		if (lowBound>=upBound) return;
		
		int m=lowBound;
		for (int i = lowBound+1; i <=upBound; i++) {
			if (unsortedArr[i]<unsortedArr[lowBound]) {
				int temp=unsortedArr[i];
				unsortedArr[i]=unsortedArr[m+1];
				unsortedArr[++m]=temp;
			}
		}
		int temp=unsortedArr[lowBound];
		unsortedArr[lowBound]=unsortedArr[m];
		unsortedArr[m]=temp;
		System.out.println("m="+m+",lowBound="+lowBound+",upBound="+upBound);
		quickSortSol1(unsortedArr,lowBound,m-1);
		quickSortSol1(unsortedArr,m+1,upBound);
	}
	
	public static void main(String[] args) {
		int[] unsortedArr= {55,41,59,26,53,58,97,93};
		System.out.println("Before Sorting. unsortedArr len="+unsortedArr.length);
		SQuickSort.quickSortSol1(unsortedArr,0, unsortedArr.length-1);
		System.out.println(Arrays.toString(unsortedArr)+",After Sorting. unsortedArr len="+unsortedArr.length);
	}
}
