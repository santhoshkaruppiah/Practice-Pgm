package com.sort;

import java.util.Arrays;

public class SInsertionSort {

	//private static int[] unsortedArr= {31, 41, 59, 26, 41, 58};
	//private static int[] unsortedArr= {5, 2, 4, 6, 1, 3};
	
	/**
	 * this sol, make a swapping many times, which is costly, not efficient--is my understanding correct?
	 */
	private static void insertSort_sol1(int[] unsortedArr){
		for (int j=1;j<=unsortedArr.length-1;j++){
			int key=unsortedArr[j];
			for(int i=j-1;i>=0;i--){
				if (unsortedArr[i]>unsortedArr[i+1]){
					unsortedArr[i+1]=unsortedArr[i];
					unsortedArr[i]=key;
				}
			}
		}
	}
	
	public static void insertSort_sol2(int[] unsortedArr){
		for (int j=1;j<=unsortedArr.length-1;j++){
			int key=unsortedArr[j];
			int i=j-1;
			while(i>=0 && unsortedArr[i]>key){
				unsortedArr[i+1]=unsortedArr[i];
				i=i-1;
			}
			unsortedArr[i+1]=key;
		}
	}
	
	public static void insertSort_sol3(int[] unsortedArr){
		for (int i = 1; i < unsortedArr.length; i++) {
			int key = unsortedArr[i];
			int j = i;
			for (j=i; j>0 && unsortedArr[j-1]>key; j--) {
				unsortedArr[j]=unsortedArr[j-1];
			}
			unsortedArr[j]=key;
		}
	}
	
	public static void insertSort_sol4(int[] unsortedArr){
		for (int i = 1; i < unsortedArr.length; i++) {
			for (int j=i; j>0 && unsortedArr[j-1]>unsortedArr[j]; j--) {
				swap(unsortedArr, j-1, j);
			}
		}
	}
	public static void main(String s[]){
		
		long startTime=System.currentTimeMillis();
		int[] unsortedArr= new int[] {1, 2, 3, 4, 1, 3,8,22,19,19,3,18,28,66,21,0,15,25};
		insertSort_sol1(unsortedArr);
		System.out.println("After Sorting [sol-1]="+Arrays.toString(unsortedArr)+" Total time-millis="+(System.currentTimeMillis()-startTime));
		
		unsortedArr= new int[] {1, 2, 3, 4, 1, 3,8,22,19,19,3,18,28,66,21,0,15,25};
		startTime=System.currentTimeMillis();
		insertSort_sol2(unsortedArr);
		System.out.println("After Sorting [sol-2]="+Arrays.toString(unsortedArr)+" Total time-millis="+(System.currentTimeMillis()-startTime));
		
		unsortedArr= new int[] {1, 2, 3, 4, 1, 3,8,22,19,19,3,18,28,66,21,0,15,25};
		startTime=System.currentTimeMillis();
		insertSort_sol3(unsortedArr);
		System.out.println("After Sorting [sol-3]="+Arrays.toString(unsortedArr)+" Total time-millis="+(System.currentTimeMillis()-startTime));
		
		unsortedArr= new int[] {1, 2, 3, 4, 1, 3,8,22,19,19,3,18,28,66,21,0,15,25};
		startTime=System.currentTimeMillis();
		insertSort_sol4(unsortedArr);
		System.out.println("After Sorting [sol-4]="+Arrays.toString(unsortedArr)+" Total time-millis="+(System.currentTimeMillis()-startTime));
	}
	
	private static void swap(int[] intArray,int one, int two) {
		int temp = intArray[one]	;
		intArray[one] = intArray[two];
		intArray[two] = temp;
	}
}
