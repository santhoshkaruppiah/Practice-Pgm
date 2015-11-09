package com.gayle;

import java.util.Arrays;

public class ArrayAdition {

	public static int[] addArr(int[] inArr,int toAdd){//toAdd should always single value [<10]
		int[] resultArr=new int[inArr.length+1];
		int resultArridx=resultArr.length;
		int carry=toAdd;
		for (int i = inArr.length-1; i >=0; i--) {
			if (inArr[i]+carry>=10){
				resultArr[resultArridx-1]=(inArr[i]+carry)%10; 
				carry=1;
			}else{
				resultArr[resultArridx-1]=(inArr[i]+carry);
				carry=0;
			}
			resultArridx--;
		}
		resultArr[0]=carry>0?carry:0;
		return resultArr;
	}
	
	public static int[] addArr2(int[] inArr,int toAdd){//toAdd should always single value [<10]
		int[] resultArr=new int[inArr.length];
		int resultArridx=resultArr.length;
		int carry=toAdd;
		for (int i = inArr.length-1; i >=0; i--) {
			if (inArr[i]+carry>=10){
				resultArr[resultArridx-1]=(inArr[i]+carry)%10; 
				carry=1;
			}else{
				resultArr[resultArridx-1]=(inArr[i]+carry);
				carry=0;
			}
			resultArridx--;
		}
		int[] r2Arr=null;
		if (carry>0){
			r2Arr=new int[resultArr.length+1];
			r2Arr[0]=carry;
			for (int i = 0,j=1; i < resultArr.length; i++,j++) {
				r2Arr[j]=resultArr[i];
			}
		}
		return r2Arr==null?resultArr:r2Arr;
	}
	
	public static void main(String[] args) {
		int[] inArr=new int[]{1,4,5,6,9};
		System.out.println(Arrays.toString(addArr(inArr, 4)));
		
		inArr=new int[]{9,9,9,9,9};
		System.out.println(Arrays.toString(addArr(inArr, 4)));
		
		inArr=new int[]{1,4,5,6,9};
		System.out.println(Arrays.toString(addArr2(inArr, 4)));
		
		inArr=new int[]{9,9,9,9,9};
		System.out.println(Arrays.toString(addArr2(inArr, 4)));
	}
}
