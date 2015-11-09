package com.pblm.javarevisited.blog;

import java.util.HashSet;
import java.util.Set;

public class StringPblm {

	public static final boolean isPalindrome(final String inString){
		if (inString==null || inString.length()==0) return false;
		/*StringBuilder sBuilder=new StringBuilder(inString);
		return sBuilder.reverse().toString().equals(inString);*/
		return reverseString(inString).equals(inString);
	}
	
	public static final String reverseString2(final String inString){//efficient, since its not looping all string values, instead on arr.len/2 times
		if (inString==null || inString.length()==0) return inString;
		char[] cStringArray=inString.toCharArray();
		char first;
		for (int i=0;i<(cStringArray.length/2);i++){
			first =  cStringArray[ i ];
			cStringArray[ i ] = cStringArray[ cStringArray.length - i - 1 ];
			cStringArray[ cStringArray.length - i - 1 ] = first;
		}
		return String.valueOf(cStringArray);
	}
	
	public static final String reverseString(final String inString){
		if (inString==null || inString.length()==0) return inString;
		final StringBuilder sBuilder=new StringBuilder();
		for (int i=inString.length()-1;i>=0;i--){
			sBuilder.append(inString.charAt(i));
		}
		return sBuilder.toString();
	}
	
	public static final String reverseStringRecursion(String inString) {
		if (inString==null || inString.length()<=1) return inString;
		return inString.charAt(inString.length()-1)+reverseStringRecursion(inString.substring(0,inString.length()-1));
	}
	
	public static String[] reverseStringArray( String[] names){
        int length = names.length;
        String first;
        for ( int i=0; i<length/2; i++ ){
            first =  names[ i ];
            names[ i ] = names[ length - i - 1 ];
            names[ length - i - 1 ] = first;
        }
        return names;
    }
	
	public static final String removeChar(final String inString,final String toRemove) {
		if (inString==null || inString.length()==0) return inString;
		return inString.replace(toRemove, "");
	}
	
	public static final String stringPermutationIterSol1(String inString) {
		if (inString==null || inString.length()==0) return inString;
		final StringBuilder sb=new StringBuilder();
		for(int i=0;i<=inString.length()-1;i++){
			for (int j = i; j <=inString.length()-1; j++) {
				sb.append(inString.substring(i,j+1));
			}
		}
		return sb.toString();
	}
	
	public static final String stringPermutationRecSol1(String inString,String tempStr,String prefixChar){
		System.out.println("tempStr="+tempStr+",prefixChar="+prefixChar);
		if (tempStr==null || tempStr.length()<=1) {
			return prefixChar=prefixChar+tempStr.substring(0);
		}
		prefixChar=prefixChar+String.valueOf(tempStr.charAt(0));
		stringPermutationRecSol1(inString,(tempStr.substring(0,tempStr.length())),String.valueOf(tempStr.charAt(0)));
		return prefixChar+stringPermutationRecSol1(inString,(tempStr.substring(1,tempStr.length())),prefixChar);
	}
	
	public static final boolean isUniqueCharInString(String inString){
		if (inString==null || inString.length()<=1) return true;
		Set<String> set=new HashSet<String>();
		for (int i=0;i<inString.length();i++) {
			if (!set.add(String.valueOf(inString.charAt(i)))){
				return false;
			}
		}
		return true;
	}
	
}