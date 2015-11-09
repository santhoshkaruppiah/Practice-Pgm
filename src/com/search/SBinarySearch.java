package com.search;

public class SBinarySearch {

	public static boolean binarySearch(int[] searchArr,int num){
		
		if(searchArr==null || searchArr.length==0) return false;
		if (searchArr.length==1) {return (num==searchArr[0]);}
		int iHead=0;
		int iTail=searchArr.length-1;
		do {
			if (searchArr[iHead]==num || searchArr[iTail]==num) return true;
			int mid=Math.round(iTail/2);
			if (num==searchArr[mid]){
				return true;
			}else if(searchArr[mid]>num){
				iTail=mid-1;
			}else if (searchArr[mid]<num) {
				iHead=mid+1;
			}
		//}while(iTail<2);
		}while(iHead==iTail);
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("In one's");
		System.out.println(SBinarySearch.binarySearch(new int[]{1,2,3,4,5}, 3));
		System.out.println(SBinarySearch.binarySearch(new int[]{1,2,3,4,5}, 6));
		System.out.println(SBinarySearch.binarySearch(new int[]{0,1,2,3,4,5}, 6));
		System.out.println(SBinarySearch.binarySearch(new int[]{0,1,2,3,4,5}, 5));
		System.out.println(SBinarySearch.binarySearch(new int[]{5,4,3,2,1}, 3));
		System.out.println(SBinarySearch.binarySearch(new int[]{4,3,2,1}, 3));
		
		System.out.println("\nBoundary case");
		System.out.println(SBinarySearch.binarySearch(new int[]{1}, 1));
		System.out.println(SBinarySearch.binarySearch(new int[]{1}, 0));
		System.out.println(SBinarySearch.binarySearch(new int[]{1,2}, 1));
		System.out.println(SBinarySearch.binarySearch(new int[]{1,2}, 2));
		System.out.println(SBinarySearch.binarySearch(new int[]{1,2}, 0));
		System.out.println(SBinarySearch.binarySearch(new int[]{10,25}, 9));
		
		System.out.println("\nIn ten's");
		System.out.println(SBinarySearch.binarySearch(new int[]{10,20,30,40,50}, 30));
		System.out.println(SBinarySearch.binarySearch(new int[]{10,20,30,40,50}, 60));
		System.out.println(SBinarySearch.binarySearch(new int[]{0,10,20,30,40,50}, 60));
		System.out.println(SBinarySearch.binarySearch(new int[]{0,10,20,30,40,50}, 50));

		

	}
}
