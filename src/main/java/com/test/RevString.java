package com.test;

public class RevString {

	public static String revString(String toRev){
		if (toRev != null && toRev.length()<=0){
			return null;
		}
		StringBuilder strbuilder= new StringBuilder();
		for (int i = toRev.length()-1; i >= 0; i--) {
			strbuilder.append(toRev.charAt(i));
		}

		return strbuilder.toString();
	}
	
	public static void main(String[] args) {
		String org="Santhosh";
		System.out.println("Original Str="+org+",rev. str="+revString("Santhosh"));
	}
}
