package com.search;

public class FindMin {

	public static final int findMinSol2(int[] sArr){
		if (sArr==null) return -1;
		if (sArr.length<=1) return sArr[0];
		int minSoFar=sArr[0];
		for (int i=1;i<sArr.length;i++){
			if (sArr[i-1]>sArr[i]) {
				minSoFar=sArr[i];
				return minSoFar;
			}
		}
		return minSoFar;
	}
	
	public static final int findMinNaive(int[] sArr){
		if (sArr==null) return -1;
		if (sArr.length<=1) return sArr[0];
		int minSoFar=sArr[0];
		for (int i=1;i<sArr.length;i++){
			minSoFar=Math.min(minSoFar, Math.min(sArr[i-1], sArr[i]));
		}
		return minSoFar;
	}
	
	public static final int findMinNaiveRec(int[] sArr,int idx){
		if (idx<=1) return sArr[idx];
		return Math.min(sArr[idx], findMinNaiveRec(sArr,idx-1));
	}
	
	public static void main(String[] args) {
		System.out.println(FindMin.findMinNaive(new int[]{3,4,5,6,7,1,2}));
		System.out.println(FindMin.findMinNaiveRec(new int[]{3,4,5,6,7,1,2},(new int[]{3,4,5,6,7,1,2}.length-1)));
		System.out.println(FindMin.findMinSol2(new int[]{3,4,5,6,7,1,2}));
	}
}
