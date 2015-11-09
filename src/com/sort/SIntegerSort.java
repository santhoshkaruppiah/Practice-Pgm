package com.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SIntegerSort {

	public static void main(String[] args) {
		Integer[] intArr=new Integer[]{7,-1,5,-2,0,3};
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		intArr=new Integer[]{7,-1,5,-2,0,3};
		Arrays.sort(intArr, new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				//return i1.equals(i2)?0:Math.abs(i1)<i2?-1:1;
				if (i1.equals(i2)) return 0;
				if (i1<0 && i2<0) return Math.abs(i1)<Math.abs(i2)?-1:1;
				if (i1>0 && i2>0) return i1<i2?1:-1;
				return (i1<i2)?-1:2;
			}
		});
		System.out.println(Arrays.toString(intArr));

	}
}
