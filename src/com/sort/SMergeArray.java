package com.sort;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SMergeArray {

	static Set<Integer> intTreeSet = new TreeSet<Integer>();
	static int[] oneArr=new int[]{-4,4,-7,0,5,1,3};
	static int[] twoArr=new int[]{-9,-8,2,8,9,4};
	static Map<Integer,Integer> intTreeMap = new TreeMap<Integer,Integer>();
	
	public static void main(String[] args) {
		for (int i = 0; i < oneArr.length; i++) {
			intTreeSet.add(oneArr[i]);
			if (i<twoArr.length)
				intTreeSet.add(twoArr[i]);
		}
		System.out.println(intTreeSet);
		
		oneArr=new int[]{-4,4,-7,0,5,1,3};
		twoArr=new int[]{-9,-8,2,8,9,4};
		for (int i = 0; i < oneArr.length; i++) {
			intTreeMap.put(oneArr[i],oneArr[i]);
			if (i<twoArr.length)
				intTreeMap.put(twoArr[i],twoArr[i]);
		}
		System.out.println(intTreeMap.keySet());
		
		oneArr=new int[]{-4,4,-7,0,5,1,3};
		twoArr=new int[]{-9,-8,2,8,9,4};
		System.out.println(Arrays.toString(merge(oneArr,twoArr)));
	}
	
	public static int[] merge(int[] oneArr,int[] twoArr){
		int[] mergeArr=new int[oneArr.length+twoArr.length];
		Arrays.sort(oneArr);
		Arrays.sort(twoArr);
		int alen=oneArr.length;
		int blen=twoArr.length;
		int onePtr=0;
		int twoPtr=0;
		int threPtr=0;
		while(onePtr<alen && twoPtr<blen){
			if (oneArr[onePtr]<=twoArr[twoPtr]) {
				mergeArr[threPtr]=oneArr[onePtr];
				onePtr++;
			}else {
				mergeArr[threPtr]=twoArr[twoPtr];
				twoPtr++;
			}
			
			threPtr++;
		}
		if (onePtr<alen) {
			for (int i = onePtr; i < alen; i++) {
				mergeArr[threPtr] = oneArr[i];
				threPtr++;
			}
		}else{
			for (int i = twoPtr; i < blen; i++) {
				mergeArr[threPtr] = twoArr[i];
				threPtr++;
			}
		}
		return mergeArr;
	}
}
