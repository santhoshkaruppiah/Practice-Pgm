package com.sort;

import java.util.Arrays;

public class SMergeSort {

	private static void merge(int[] unSortedArr, int startIdx, int midIdx,int endIdx) {
		System.out.println("sub-routine merge:: startIdx="+startIdx+",midIdx="+midIdx+",endIdx="+endIdx);
		int[] helperArr= new int[unSortedArr.length];
		for (int i = startIdx; i <= endIdx; i++) {
			helperArr[i]=unSortedArr[i];
		}
		System.out.println("Helper Array::"+Arrays.toString(helperArr));
		int i = startIdx;
	    int j = midIdx + 1;
	    int k = startIdx;
	    while (i <= midIdx && j <= endIdx) {
	      if (helperArr[i] <= helperArr[j]) {
	    	  unSortedArr[k] = helperArr[i];
	        i++;
	      } else {
	    	  unSortedArr[k] = helperArr[j];
	        j++;
	      }
	      k++;
	    }
	    while (i <= midIdx) {
	    	unSortedArr[k] = helperArr[i];
	      k++;
	      i++;
	    }
		System.out.println("unSortedArr Array::"+Arrays.toString(unSortedArr));
	}

	private static void mergeSort(int[] unSortedArr, int startIdx, int endIdx) {
		//System.out.println("mergeSort::startidx="+startIdx+",endIdx="+endIdx);
		if (startIdx < endIdx) {
			int midIdx = (int) Math.ceil((startIdx + endIdx) / 2);
		    //int midIdx = endIdx + (startIdx - endIdx) / 2;
			//System.out.println("midIdx="+midIdx);
			mergeSort(unSortedArr, startIdx, midIdx);
			//System.out.println("called with startIdx and mididx");
			mergeSort(unSortedArr, midIdx + 1, endIdx);
			//System.out.println("called with midIdx+1 and endIdx");
			merge(unSortedArr, startIdx, midIdx, endIdx);
			//System.out.println("called merge to merge from startIdx and mididx");
		}
	}

	public static void main(String s[]) {
		//int[] unSortedArr={2,4,5,7,1,2,3,6};
		//int[] unSortedArr={22,44,35,27,21,32,63,96};
		//int[] unSortedArr = { 2, 4, 8, 7, 10, 3, 2, 1,18 };
		int[] unSortedArr = {3,41,52,26,38,57, 9, 49};
		// merge(unSortedArr, 0, 4, 8);
		//System.out.println(Math.ceil(1.6));
		//System.out.println("len="+unSortedArr.length);
		mergeSort(unSortedArr, 0, unSortedArr.length-1);
		System.out.println("Sorted-Arr::" + Arrays.toString(unSortedArr));
	}
}
