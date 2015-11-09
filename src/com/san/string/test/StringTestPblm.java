package com.san.string.test;

public class StringTestPblm {

	public static void main(String[] args) {
//		System.out.println(removeDuplicates_Naive(new char[]{'s','a','s'}));
//		System.out.println(removeDuplicates_Naive(new char[]{'s','s'}));
//		System.out.println(removeDuplicates_Naive(new char[]{'s','a','s','s'}));
//		System.out.println(removeDuplicates_Naive(new char[]{'s','a','s','v','s'}));
//		System.out.println(removeDuplicates_Naive(new char[]{'s','a','s','v','s','v'}));
//		System.out.println(removeDuplicates_Naive(new char[]{'s','a','v'}));
		fortest_postInc();
		fortest_preInc();
	}
	
	public static char[] removeDuplicates_Naive(char[] str) {
		
		if (str.length<=1) return str;//no chance of duplicates
		
		char duplicateFlag = '!';
		
		for(int i=0;i<str.length;i++) {
			for(int j=i+1;j<str.length;j++) {
				if (str[i]==str[j]){
	//				System.out.println("duplicate found");
					str[j]=duplicateFlag;
				}
			}
		}
		
		return str;
	}
	
	public static void fortest_postInc(){
		System.out.println("Post Inc-Test");
		for (int i = 0; func(i,i<2); i++) {
			
		}
	}
	
	public static void fortest_preInc(){
		System.out.println("Pre Inc-Test");
		for (int i = 0; func(i,i<2); ++i) {
			
		}
	}
	
	public static boolean func(int i,boolean exp){
		System.out.println("i="+i+",exp="+exp);
		return exp;
	}
}
