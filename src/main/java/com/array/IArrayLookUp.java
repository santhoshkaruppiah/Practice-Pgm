package com.array;

public interface IArrayLookUp {

	/**
	 *  print current and next elem
	 * Output": Might contain duplicates, since next elem becomes current each time we move pointer 
	 * @param arr
	 */
	void printCurrNext(int[] arr);
	
	/**
	 *  print current and prev elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	void printCurrPrev(int[] arr);
	
	/**
	 *  print current and ALL prev elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	void printCurrAllPrev(int[] arr);
	
	/**
	 *  print current,prev,next elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	void printCurrPrevNext(int[] arr);
	
	/**
	 *  print current and ALL next elem
	 * Output: Might contain duplicates, since curr elem becomes prev each time we move pointer 
	 * @param arr
	 */
	void printCurrAllNext(int[] arr);
}