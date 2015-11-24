package com.gayle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StringPblm {
	
	static boolean[] asciiArr = new boolean[256];//used by isUniq method  
	
	public static void main(String[] args) {
		//String toTest = "santhosh";
//		String toTest = "cat";
//		System.out.println("is uniq.="+isUniq(toTest));
		//System.out.println("rev string="+reverseString_Sol1("santhosh"));
		//System.out.println(compressString_Sol1("aaaabcccd"));
		//System.out.println(compressString_Sol1("aabaddccb"));
		//System.out.println("Anagram of 2 string is::"+isAnagramString("santhosh",reverseString_Sol1("santhosh")));
		//System.out.println("Paired Star val="+pairStar("aaababbcdd"));
//		System.out.println("end string with x sol="+endX_Sol2("xxssdxxgx"));
//		char[] k= new char[]{'s','a','n','t','h','o','s','h'};
//		removeDuplicates(k);
//		System.out.println(removeDuplicates("santhosh"));
		System.out.println(permutate("Santhosh"));
	}
	
	
	public static String removeDuplicatesUsingSet(String s) {
		Set<Character> noDup=new HashSet<Character>();
		for (int i = 0; i < s.length(); i++) {
	        noDup.add(s.charAt(i));
	    }
	    return noDup.toString();
	}
	
	public static String removeDuplicates(String s) {
	    StringBuilder noDupes = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        String si = s.substring(i, i + 1);
	        if (noDupes.indexOf(si) == -1) {
	            noDupes.append(si);
	        }
	    }
	    return noDupes.toString();
	}
	
	// function takes a char array as input.
	// modifies it to remove duplicates and adds a 0 to mark the end
	// of the unique chars in the array.
	public static void removeDuplicates(char[] str) {
	  if (str == null) return; // if the array does not exist..nothing to do return.
	  int len = str.length; // get the array length.
	  if (len < 2) return; // if its less than 2..can't have duplicates..return.
	  int tail = 1; // number of unique char in the array.
	  // start at 2nd char and go till the end of the array.
	  for (int i = 1; i < len; ++i) { 
	    int j;
	    // for every char in outer loop check if that char is already seen.
	    // char in [0,tail) are all unique.
	    for (j = 0; j < tail; ++j) {
	      if (str[i] == str[j]) break; // break if we find duplicate.
	    }
	    // if j reachs tail..we did not break, which implies this char at pos i
	    // is not a duplicate. So we need to add it our "unique char list"
	    // we add it to the end, that is at pos tail.
	    if (j == tail) {
	      str[tail] = str[i]; // add
	      ++tail; // increment tail...[0,tail) is still "unique char list"
	    }
	  }
	  str[tail] = 0; // add a 0 at the end to mark the end of the unique char.
	  
	  System.out.println(str);
	}
	
	public static String compressString_Sol1(String toCompress){
		//aaaabcccd--o/p=a4b1c3d1
		//aabaddccb-o/p=a3b2d2c2
		char[] charArr = toCompress.toCharArray();
		char pre_Val=charArr[0];
		StringBuffer buf = new StringBuffer();
		int count=0;
		for (int idx = 0; idx < charArr.length; idx++) {
			if (charArr[idx]==pre_Val){
				count++;
			}else{
				buf.append(pre_Val);
				buf.append(count);
				count=1;
				pre_Val=charArr[idx];
			}
		}
		buf.append(pre_Val);
		buf.append(count);
		return buf.toString();
	}
	
	public static String reverseString_Sol1(String toReverse){
		StringBuilder reversedString = new StringBuilder();
		for (int idx = toReverse.length()-1; idx >=0 ; idx--) {
			reversedString.append(toReverse.toCharArray()[idx]);
		}
		
		return reversedString.toString();
	}
	
	public static boolean isAnagramString(String toCompare1,String toCompare2){
		char[] char1=toCompare1.toCharArray();
		char[] char2=toCompare2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		return String.valueOf(char1).equals(String.valueOf(char2));
	}
	
	public static boolean isUniq(String toFind){
		boolean isUniq=true;
		
		if (toFind==null && toFind.equals("") )
			return isUniq=false;
		
		for (int strIdx = 0; strIdx < toFind.length(); strIdx++) {
			int asciiVal=toFind.charAt(strIdx);
			if (!asciiArr[asciiVal]){
				asciiArr[asciiVal] = true;
			}else{
				return isUniq=false;
			}
		}
		
		return isUniq;
	}
	
	//below are not from gayle book
	
	public static String pairStar(String toPair){//Given a string, compute a new string where identical chars that are adjacent 
												 //in the original string are separated from each other by a "*"
		
		char[] charArr=toPair.toCharArray();
		char prev = charArr[0];
		for (int idx = 1; idx < charArr.length; idx++) {
			
			if (charArr[idx]==prev){
				charArr[idx]='*';
			}else{
				prev = charArr[idx];
			}
		}
		
		return String.valueOf(charArr);
	}
	
	public static String endX(String toCompute){//Given a string, compute a new string where all the lowercase 'x' chars 
												//have been moved to the end of the string
		StringBuffer resultString= new StringBuffer();
		StringBuffer xIdx= new StringBuffer();
		char[] charArr = toCompute.toCharArray();
		int target = 'x';
		for (int idx = 0; idx < charArr.length; idx++) {
			if (target==charArr[idx]){
				xIdx.append(idx);
			}
		}
		
		return "";
	}
	
	
	public static String endX_Sol2(String toCompute){//copied from internet,, it uses recursive method
		if (toCompute.equals("")) return "";
		char c = toCompute.charAt(0);
		String rest = endX_Sol2(toCompute.substring(1));
		return c == 'x' ? rest + c : c + rest;
	}
	
	public static List<String> permutate(String s) {
		
		List<String> permutations = new ArrayList<String>();
		if (s==null) return null;
		if(s.length()==0) {
			permutations.add("");
			return permutations;
		}
		char toAdd = s.charAt(0);
		String remainder = s.substring(1);
		List<String> words = permutate(remainder);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				permutations.add(insertWord(word,toAdd,i));
			}
		}
		return (permutations);
	}


	private static String insertWord(String word, char toAdd, int i) {
		String start = word.substring(0,i);
		String end = word.substring(i);
		return (start+toAdd+end);
	}
}
