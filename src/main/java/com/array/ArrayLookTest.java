package com.array;

public class ArrayLookTest implements IArrayLookUp {
	
	public static void main(String[] args) {
		ArrayLookTest arrayLookTestIns  = new ArrayLookTest();
		
//		System.out.println("Case-1");
//		arrayLookTestIns.printCurrNext(new int[]{2, 5, 1, 5});
//		System.out.println("Case-2");
//		arrayLookTestIns.printCurrNext(new int[]{2, 5});
//		System.out.println("Case-3");
//		arrayLookTestIns.printCurrNext(new int[]{2});
		
//		System.out.println("Case-1");
//		arrayLookTestIns.printCurrPrev(new int[]{2, 5, 1, 5});
//		System.out.println("Case-2");
//		arrayLookTestIns.printCurrPrev(new int[]{2, 5});
//		System.out.println("Case-3");
//		arrayLookTestIns.printCurrPrev(new int[]{2});
		
//		System.out.println("Case-1");
//		arrayLookTestIns.printCurrAllPrev(new int[]{2, 5, 1, 5});
//		System.out.println("Case-2");
//		arrayLookTestIns.printCurrAllPrev(new int[]{2, 5});
//		System.out.println("Case-3");
//		arrayLookTestIns.printCurrAllPrev(new int[]{2});
		
//		
//		System.out.println("Case-1");
//		arrayLookTestIns.printCurrPrevNext(new int[]{2, 5, 1, 5});
//		System.out.println("Case-2");
//		arrayLookTestIns.printCurrPrevNext(new int[]{2, 5});
//		System.out.println("Case-3");
//		arrayLookTestIns.printCurrPrevNext(new int[]{2});
		
		System.out.println("Case-1");
		arrayLookTestIns.printCurrAllNext(new int[]{2, 5, 1, 5});
		System.out.println("Case-2");
		arrayLookTestIns.printCurrAllNext(new int[]{2, 5});
		System.out.println("Case-3");
		arrayLookTestIns.printCurrAllNext(new int[]{2});
		
	}

	/**
	 *  print current and next elem
	 * Output": Might contain duplicates, since next elem becomes current each time we move pointer 
	 * @param arr
	 */
	@Override
	public void printCurrNext(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			System.out.println("current="+arr[i]+",next="+arr[i+1]);
		}
	}
	
	/**
	 *  print current and prev elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	public void printCurrPrev(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			System.out.println("current="+arr[i]+",prev="+arr[i-1]);
		}
	}
	
	/**
	 *  print current and ALL prev elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	public void printCurrAllPrev(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j>=0;j--) {
				System.out.println("current="+arr[i]+",prev="+arr[j]);
			}
		}
	}
	
	/**
	 *  print current,prev,next elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	public void printCurrPrevNext(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			String prev = (i==0)?"":String.valueOf(arr[i-1]);
			System.out.println("prev="+prev+",current="+arr[i]+",next="+arr[i+1]);
		}
	}
	
	/**
	 *  print current and ALL next elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	public void printCurrAllNext(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println();
			for (int j = i+1; j<arr.length;j++) {
				System.out.print("current="+arr[i]+",next="+arr[j]);
			}
		}
	}
}
