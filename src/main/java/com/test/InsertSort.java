package com.test;

/**
 * 
 * Worst Case	: O(n^2)
 * Average Case : O(n^2)
 * Best Case 	: O(n)
 * @author user1
 *
 */
public class InsertSort {

	//static int[] intArray =new int[]{0,1,2,3,4,5,6,7,8,9,10};//sorted array
	static int[] intArray =new int[]{9,3,1,4,6,7,2,5,8,10};//un-sorted array
	//static int[] intArray =new int[]{9,3,7,6,8,1,2,5,8,10};//un-sorted array
	
	private static void printArray(){
		System.out.println("Print Array Values");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("Idx ="+i+", val ="+intArray[i]+"||");
		}
		System.out.println();
	}
	
	private static void insertSort(){//this sort in asc order
		int counter=0;

		for (int i = 1; i < intArray.length; i++) {//the 0th element will be 
												   //sorted on first iteration [if required]
			int key=intArray[i];
			int j= i;
			while (j>0 && (intArray[j-1]>key)){//idea is to look-behind the numbers of the current one 
											   //and swap if necessary.
				counter++;
				intArray[j] = intArray[j-1];
				j--;
			}
			intArray[j] = key;
		}
		System.out.println("whille counter val="+counter);
	}
	
	private static void insertSort2(){//another approach,, this sort in desc order
		
		for (int i = 1; i < intArray.length; i++) {
			int key=intArray[i];
			int j= i;
			while (j>0 && (key>intArray[j-1])){//idea is to look-behind the numbers of the current one 
											   //and swap if necessary.
				intArray[j] = intArray[j-1];
				j--;
			}
			intArray[j] = key;
		}
	}
	
	private static void insertSort3(){//another approach,, this sort in asc order
		int counter=0;

		for (int i = 1; i < intArray.length; i++) {
			int key=intArray[i];
			int j= i;
			while (j>0 && (key<intArray[j-1])){//idea is to look-behind the numbers of the current one 
											   //and swap if necessary.
				counter++;
				intArray[j] = intArray[j-1];
				j--;
			}
			intArray[j] = key;
		}
		System.out.println("whille counter val="+counter);
	}

	public static void main(String[] args) {
		System.out.println("Before Values");
		printArray();
		long startTime = System.currentTimeMillis();
//		System.out.println("insertSort");
//		insertSort();
		//System.out.println("insertSort2");
		//insertSort2();
		System.out.println("insertSort3");
		insertSort3();
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("After Values");
		printArray();
		System.out.print("startTime= "+startTime+", endTime="+endTime);
		long totalMilliSec=endTime-startTime;
		System.out.print(", Total Time [in totalMilliSec]= "+totalMilliSec);
		long totalSeconds = (long) (endTime-startTime*0.0010);
		System.out.print(", Total Time [in seconds]= "+totalSeconds);
		long totalMin = totalSeconds/60;
		System.out.print(", Total Time [in min]= "+totalMin);
	}
}
