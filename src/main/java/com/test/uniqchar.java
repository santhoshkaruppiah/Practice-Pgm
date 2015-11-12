package com.test;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class uniqchar {

	public static void main(String[] args) {
//		String d="aecdbf";
//		int idx=0;
//		for (int i=0;i<d.length();i++) {
//			int ascciVal=d.charAt(idx);
//			int diffVal=d.charAt(idx)-'a';
//			int shiftedVal=1<<ascciVal;
//			System.out.println("Char="+d.charAt(idx)+",ASCII Val="+ascciVal+",diffVal="+diffVal+",shifted Val="+shiftedVal);
//			idx++;
//		}
		//System.out.println(isUniqueChars("abdcsa"));
		String as="Apple is not";
		try{
		leftShift(1,as);
		}catch(Exception s){
			s.printStackTrace();
		}
	}
	
	public static boolean isUniqueChars(String str){
		
		int checker=0;
		for (int i = 0; i < str.length(); i++) {
			int val=str.charAt(i)-'a';
			if ((checker & (1 << val))>0){
				System.out.println("EXIT----Character="+str.charAt(i)+",val="+(int)str.charAt(i)+",val-a="+val+",checker="+checker+",,checker&(1<<val)=="+(checker & (1 << val)));
				return false;
			}
			checker |=(1<<val);
			System.out.println("Character="+str.charAt(i)+",val="+(int)str.charAt(i)+",val-a="+val+",checker="+checker);
		}
		return true;
	}
	
	public static void leftShift(int shiftTo,String value) throws UnsupportedEncodingException{
		char[] convertedVal=  new char[value.length()];
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		for (int i = 0; i < value.length(); i++) {
			int val = value.charAt(i);
			int shiftedVal=1<<val;
			out.println("Char at i="+value.charAt(i)+",ASCII Val="+val+",Shifted Val="+shiftedVal+",shifted char val="+(char)shiftedVal+", a val="+(char)65);
			convertedVal[i] = (char) shiftedVal;
		}
		out.println("Converted Val="+String.valueOf(convertedVal));
	}
}
