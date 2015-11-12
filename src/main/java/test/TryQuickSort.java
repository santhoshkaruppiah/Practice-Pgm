package test;

import java.util.Arrays;

public class TryQuickSort {

	public static void quickSortSol1(int[] arrToSort, int sIdx,int eIdx){
		if (sIdx>=eIdx) return;//reason out when this condition occur
		int partIdx=sIdx;
		for (int i=sIdx+1;i<=eIdx;i++){
			if (arrToSort[i]<arrToSort[sIdx])
				swap(arrToSort, ++partIdx, i);
		}
		swap(arrToSort, partIdx, sIdx);
		quickSortSol1(arrToSort,sIdx, partIdx-1);
		quickSortSol1(arrToSort,partIdx+1,eIdx);
	}
	
	private static void swap(int[] arrToSwap, int idx1,int idx2){
		int temp=arrToSwap[idx1];
		arrToSwap[idx1]=arrToSwap[idx2];
		arrToSwap[idx2]=temp;
	}
	
	public static void quickSortSol2(int[] arrToSort, int sIdx,int eIdx){
		if (sIdx>=eIdx) return;
		int partVal=arrToSort[sIdx];
		int i=sIdx;
		int j=eIdx+1;
		for (int k : arrToSort) {
			do {i++;} while(i<=eIdx && arrToSort[i]<partVal);
			do {j--;} while(arrToSort[j]>partVal);
			if (i>j) break;
			swap(arrToSort, i, j);
		}
		swap(arrToSort, sIdx, j);
		quickSortSol2(arrToSort, sIdx, j-1);
		quickSortSol2(arrToSort, j+1,eIdx);
	}
	
	public static void main(String[] args) {
		int[] arrToSort=new int[]{2,1,0,7,3,74,45};
		quickSortSol1(arrToSort,0,arrToSort.length-1);
		System.out.println(Arrays.toString(arrToSort));
		arrToSort=new int[]{2,1,0,7,3,74,45};
		quickSortSol2(arrToSort,0,arrToSort.length-1);
		System.out.println(Arrays.toString(arrToSort));
	}
}
