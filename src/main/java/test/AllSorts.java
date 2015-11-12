package test;

import java.util.Arrays;


public class AllSorts {

	public static class InsertionSort{
		
		public static void insert_v1(int[] arrayToSort){
			for (int i = 1; i < arrayToSort.length; i++) {
				for (int j = i; j > 0; j--) {
					if (arrayToSort[j]<arrayToSort[j-1]) {
						swap(arrayToSort, j, j-1);
					}
				}
			}
			System.out.println("Insertion Sort,After="+Arrays.toString(arrayToSort));
		}
	}
	
	public static class SelectionSort{
		
		public static void selection_v1(int[] arrayToSort){
			for (int i = 0; i < arrayToSort.length; i++) {
				int minIdx=i;
				for (int j = i+1; j < arrayToSort.length; j++) {
					if (arrayToSort[j]<arrayToSort[minIdx])
						minIdx=j;
				}
				swap(arrayToSort, minIdx,i);
			}
			System.out.println("Selection Sort,After="+Arrays.toString(arrayToSort));
		}
	}
	
	public static class ShellSort {
		public static void shellSort_v1(int[] arrayToSort){
			int N=arrayToSort.length;
			int limit=N/3;//check N is not <=0
			int h=1;
			while(h<limit){//3X+1 seq
				h=3*h+1;
			}
			while(h>=1) {
				for (int i = h; i < N; i++) {
					for (int j=i;
							(j>=h && (arrayToSort[j]<arrayToSort[j-h]));
							j=j-h){
						swap(arrayToSort, j, j-h);
					}
				}
				h=h/3;
			}
			System.out.println("Shell Sort,After="+Arrays.toString(arrayToSort));
		}
	
	}
	private static void swap(int[] arrToSwap, int idx1,int idx2){
		int temp=arrToSwap[idx1];
		arrToSwap[idx1]=arrToSwap[idx2];
		arrToSwap[idx2]=temp;
	}
	
	public static class IterativeMergeSort {
		
	}
	
	public static class RecurseMergeSort {
		
		public static void merge(int[] toSort, int[] auxArray, int low, int mid, int hi){

			for (int i = low; i <= hi; i++) {
				auxArray[i] = toSort[i];
			}
			
			int i=low,j=mid+1;
			
			for (int k = low; k <= hi; k++) {
				if (i>mid) 
					toSort[k]=auxArray[j++];
				else if (j>hi)
					toSort[k] = auxArray[i++];
				else if (auxArray[j]<auxArray[i])
					toSort[k]=auxArray[j++];
				else
					toSort[k]=auxArray[i++];
			}
		}
		
		public static void mergeSort(int [] toSort, int[] auxArray,int low,int hi){
			if (hi<=low) return;
			int mid=low+(hi-low)/2;
			mergeSort(toSort,auxArray,low,mid);//left half
			mergeSort(toSort,auxArray,mid+1,hi);//right half
			merge(toSort, auxArray, low,mid,hi);
		}
		
		public static void mergerSort(int[] toSort){
			int aux[]=new int[toSort.length];
			mergeSort(toSort,aux,0,toSort.length-1);
			System.out.println("After="+Arrays.toString(toSort));
			System.out.println("After,[aux]="+Arrays.toString(aux));
		}
	}
	
	
	public static void main(String[] args) {
		int arrayToSort1[]={7,10,5,3,8,4,2,9,6};
		System.out.println("Before="+Arrays.toString(arrayToSort1));
		InsertionSort.insert_v1(arrayToSort1);
		int arrayToSort2[]= {7,10,5,3,8,4,2,9,6};
		System.out.println("Before="+Arrays.toString(arrayToSort2));
		SelectionSort.selection_v1(arrayToSort2);
		int arrayToSort3[]= {7,10,5,3,8,4,2,9,6};
		System.out.println("Before="+Arrays.toString(arrayToSort3));
		ShellSort.shellSort_v1(arrayToSort3);
		int arrayToSort4[]={7,10,5,3,8,4,2,9,6};
		System.out.println("Before="+Arrays.toString(arrayToSort4));
		RecurseMergeSort.mergerSort(arrayToSort4);
		
	}
	
}
