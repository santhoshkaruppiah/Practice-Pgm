package com.test;

import java.util.Arrays;

public class TestShellSortt {

	//interval sequence or gap sequence formula:: h = 3*h + 1 OR h=(h-1)/3
	//static int[] intArray =new int[]{0,1,2,3,4,5,6,7,8,9,10};//sorted array
	//static int[] intArray =new int[]{9,3,1,4,6,7,2,5,8,10};//un-sorted array
	// Test data

	//77 99 44 55 22 88 11 0 66 33 --unsorted
	//0 11 22 33 44 55 66 77 88 99--sorted one
	static int[] intArray =new int[]{77,99,44,55,22,88,11,0,66,33};//un-sorted array
		
	public static void main(String[] args) {
		System.out.println("Before Sort Array Values");
		System.out.println(Arrays.toString(intArray));
		shellSort();
		//shellSort_bookImpl();
		System.out.println("After Sort Array Values");
		System.out.println(Arrays.toString(intArray));
	}
	
	public static void shellSort(){
		int curr,outer;
		int h=1;
		int while1Counter=0;
		
		int while2Counter=0;
		int for1Counter=0;
		int swap1Counter=0;

		while(h<=intArray.length/3){
			h=3*h+1;	
			while1Counter++;
		}
		//h values will be 1[inti],4,13,40,121,...
		
		System.out.println("while1Counter val="+while1Counter);
		
		while(h>0){
			while2Counter++;
			for(int i=h;i<intArray.length;i++){
				for1Counter++;
				curr=intArray[i];
				outer = i;
				
				while (outer > h-1 && intArray[outer-h]>=curr){
					swap1Counter++;
					intArray[outer] = intArray[outer-h]; 
					outer -= h;
				}//end if comparison
				intArray[outer] = curr; 
			}//for loop end
			System.out.println("for1Counter val="+for1Counter);
			System.out.println("swap1Counter val="+swap1Counter);
			h = (h-1)/3; //decrease h
		}//end while h>0
		
		System.out.println("while1Counter val="+while2Counter);


	}
	
	public static void shellSort_bookImpl(){
		int inner,outer,temp;
		int h = 1; // find initial value of h 
		
		while(h <=intArray.length/3)
			h = h*3+ 1;// (1, 4, 13, 40, 121, ...)
		System.out.println("h value="+h);
		
		while(h>0) {// decreasing h, until h=1
			// h-sort the file 
			for(outer=h; outer<intArray.length; outer++){ 
				temp = intArray[outer];
				inner = outer;
				// 	one subpass (eg 0, 4, 8) 
				while(inner > h-1 && intArray[inner-h] >= temp){ 
					intArray[inner] = intArray[inner-h]; 
					inner -= h;
				} 
				intArray[inner] = temp; 
			} // end for
			
			h = (h-1) / 3; //decrease h
		} // end while(h>0)
	}
	
//	int[] s= {9,4,8,2};
//	s[0] ^=s[1];
//	s[1] ^=s[0];
//	s[0] ^=s[1];
//O/P::[4, 9, 8, 2]
	
}
