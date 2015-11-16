package com.array;

public class ArrayReverseLookTest implements IArrayLookUp{

	public static void main(String[] args) {
		ArrayReverseLookTest arrayReverseLookTestIns = new ArrayReverseLookTest();
		arrayReverseLookTestIns.printCurrNext(new int[]{2,4, 6, 7, 9});
	}

	@Override
	public void printCurrNext(int[] arr) {
		for (int i = arr.length-1;i>0;i--){
			System.out.println("Current="+arr[i]+",next="+arr[i-1]);
		}
	}

	@Override
	public void printCurrPrev(int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCurrAllPrev(int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCurrPrevNext(int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCurrAllNext(int[] arr) {
		// TODO Auto-generated method stub
		
	}

}
