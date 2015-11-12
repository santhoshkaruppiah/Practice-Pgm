package com.sort;

public class SBubbleSort {
	
	//static int[] intArray =new int[]{0,1,2,3,4,5,6,7,8,9,10};//sorted array
	//static int[] intArray =new int[]{9,3,1,4,6,7,2,5,8,10};//un-sorted array
	// Test data

	//77 99 44 55 22 88 11 0 66 33 --unsorted
	//0 11 22 33 44 55 66 77 88 99--sorted one

	private static void printArray(int[] intArray){
		System.out.println("Print Array Values");
		for (int i = 0; i < intArray.length; i++) {
			//System.out.print("Idx ="+i+", val ="+intArray[i]+"||");
			System.out.print("val ="+intArray[i]+"||");
		}
		System.out.println();
	}
	
	//1.	Compare two elements.
	//2.	If the one on the left is greater, swap them. 
	//3.	Move one position right.
	public static void bubbleSort(int[] intArray){
		for (int j = 0; j < intArray.length; j++) //To repeat comparison N times to sort 
			for (int i = 0; i < intArray.length-1; i++) {//this loop does comparison and sort
				if (intArray[i]>intArray[i+1]) 
						swap(intArray,i,i+1);
			}
		
	}
	
	private static void swap(int[] intArray,int one, int two) {
		int temp = intArray[one]	;
		intArray[one] = intArray[two];
		intArray[two] = temp;
	}

	public static void main(String[] args) {
		int[] intArray =new int[]{77,99,44,55,22,88,11,0,66,33};//un-sorted array
		printArray(intArray);
		
		bubbleSort(intArray);
		printArray(intArray);
		intArray =new int[]{99,44};
		bubbleSort(intArray);
		printArray(intArray);
	}
	
	
}
