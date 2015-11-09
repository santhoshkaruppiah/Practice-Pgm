package com.sort;

import java.util.Arrays;

public class SMergeSort {
	
	private static void merge(int[] unSortedArr, int startIdx,int midIdx,int endIdx){
		System.out.println("sub-routine merge:: startIdx="+startIdx+",midIdx="+midIdx+",endIdx="+endIdx);
		if (startIdx==0 && endIdx==1){return;}
		int leftArrIdx  = midIdx-startIdx+1;
		int rightArrIdx = endIdx-midIdx;
		int[] leftArr  = new int[leftArrIdx+1];
		int[] rightArr = new int[rightArrIdx+1];
		System.out.println("sub-routine merge:: leftArrIdx="+leftArrIdx+",rightArrIdx="+rightArrIdx);
		for (int idx=0;idx<=leftArrIdx-1; idx++) {
			//if (startIdx+idx-1!=-1){leftArr[idx]=unSortedArr[startIdx+idx-1];System.out.print(",idx val=");System.out.print(startIdx+idx-1);}
			if (startIdx+idx!=-1){leftArr[idx]=unSortedArr[startIdx+idx];System.out.print(",idx val=");System.out.print(startIdx+idx);}
		}
		for (int idx=0;idx<=rightArrIdx-1; idx++) {
			System.out.print(",idx val=");
			System.out.print(midIdx+idx);
			rightArr[idx] = unSortedArr[midIdx+idx];
		}
		System.out.println("\nleft-arr"+Arrays.toString(leftArr)+",right-arr"+Arrays.toString(rightArr));
		leftArr[leftArr.length-1]=-1111111;//for sentinel
		rightArr[rightArr.length-1]=-22222;;//for sentinel
		System.out.println("left-arr"+Arrays.toString(leftArr)+",right-arr"+Arrays.toString(rightArr));
		int i=0,j=0;
		for (int k = startIdx; k <endIdx; k++) {
			try{
				if (leftArr[i]<=rightArr[j]){
				//if (leftArr[i]<rightArr[j]){
					if (leftArr[i]!=-1111111){unSortedArr[k]= leftArr[i];}
					i++;
				} else {
					if (rightArr[j]!=-22222){
						unSortedArr[k]= rightArr[j];
					}
					j++;
				}
			}catch(Throwable s){System.out.println(s);}
		}
		System.out.println("Merged-Arr=="+Arrays.toString(unSortedArr));

	}
	
	private static void mergeSort(int[] unSortedArr,int startIdx,int endIdx){
		System.out.println("mergeSort::startidx="+startIdx+",endIdx="+endIdx);
		if (startIdx<endIdx){
			
			int midIdx= (int)Math.ceil((startIdx+endIdx)/2);
			System.out.println("midIdx="+midIdx);
			mergeSort(unSortedArr,startIdx,midIdx);
			mergeSort(unSortedArr,midIdx+1,endIdx);
			merge(unSortedArr,startIdx,midIdx,endIdx);
		}
	}
	
	public static void main(String s[]){
		int[] unSortedArr={2,4,5,7,1,2,3,6};
		//merge(unSortedArr, 0, 4, 8);
		System.out.println("len="+unSortedArr.length);
		mergeSort(unSortedArr,0,unSortedArr.length);
		System.out.println(Arrays.toString(unSortedArr));
	}
}
