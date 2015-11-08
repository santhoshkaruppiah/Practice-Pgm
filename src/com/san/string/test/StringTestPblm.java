package com.san.string.test;

public class StringTestPblm {

	public static void main(String[] args) {
		
	}
	
	public static void removeDuplicates(char[] str) {
		
		if (str.length<=1) return;//no chance of duplicates
		
		char duplicateFlag = '!';
		
		for(int i=1;i<str.length;i++){
			for(int j=0;j<str.length;j++) {
				if (str[j]==str[j-1]){
					str[j-1]=duplicateFlag;
				}
			}
		}
		
	}
}
