package com.sort;

import java.util.Arrays;
import java.util.Comparator;

public class StringSort {

	public static void main(String[] args) {
		String toSort="AmeriCa";
		char[] toSortCharArr=toSort.toCharArray();
		Arrays.sort(toSortCharArr);
		System.out.println(toSortCharArr);
		Character[] charArr=getCharacterArr(toSort);
		Arrays.sort(charArr, new Comparator<Character> () {
			 public int compare(Character c1, Character c2) {
				 int cmp=Character.compare(Character.toLowerCase(c1), Character.toLowerCase(c2));
				 if (cmp!=0) return cmp;
				 return Character.compare(Character.toLowerCase(c1), Character.toLowerCase(c2));
			 }
		});
		System.out.println(Arrays.toString(charArr));
	}
	
	public static Character[] getCharacterArr(String inStr){
		Character[] charArr=new Character[inStr.length()];
		for (int i = 0; i < inStr.length(); i++)
			charArr[i] = inStr.charAt(i);
		return charArr;
	}
}
