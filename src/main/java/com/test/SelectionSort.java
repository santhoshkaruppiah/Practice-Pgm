package com.test;

public class SelectionSort {

	//static int[] intArray =new int[]{0,1,2,3,4,5,6,7,8,9,10};//sorted array
	//static int[] intArray =new int[]{9,3,1,4,6,7,2,5,8,10};//un-sorted array
	// Test data

	//77 99 44 55 22 88 11 0 66 33 --unsorted
	//0 11 22 33 44 55 66 77 88 99--sorted one
	static int[] intArray =new int[]{77,99,44,55,22,88,11,0,66,33};//un-sorted array

	private static void printArray(){
		System.out.println("Print Array Values");
		for (int i = 0; i < intArray.length; i++) {
			//System.out.print("Idx ="+i+", val ="+intArray[i]+"||");
			System.out.print(intArray[i]+"||");
		}
		System.out.println();
	}
	
	private static void swap(int one, int two) {
		int temp = intArray[one]	;
		intArray[one] = intArray[two];
		intArray[two] = temp;
	}
	
	//My implementation
	public static void selectionSort_myImpl1(int[] intArray){
		int k= 0;
		for (int i = 0; i < intArray.length; i++) {
			int val=intArray[i] ;
			int index = i;
			int swapIndex = 0;
			while(index!=intArray.length){
				
				if (val>intArray[index]){
					swapIndex = index;
					val= intArray[swapIndex];
				}
//				System.out.println("i="+i+",index="+index+",swap index="+swapIndex);
				index ++; 
			}
			
			if (swapIndex!=0){
				swap(i,swapIndex);
				k++;
			}
		}
		System.out.println("Swap hit count="+k);
	}
	
	public static void selectionSort_bookImp(int[] intArray){ 
		int out, in, min;
		for(out=0; out<intArray.length-1; out++) {
			min = out; 
			for(in=out+1; in<intArray.length; in++)
			if(intArray[in] < intArray[min] ) 
				min = in;
			swap(out, min);	// swap them
		} 
	} 
	
	public static void selecSort_myImpl2(int len){
		if (len==0) return;
		int lenCpy=len;
		
	}
	
	public static void main(String[] args) {
		printArray();
		selectionSort_myImpl1(intArray);
		printArray();
		intArray = new int[]{77,99,44,55,22,88,11,0,66,33};//un-sorted array
		selectionSort_bookImp(intArray);
		printArray();
	}
}
