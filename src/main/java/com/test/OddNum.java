package com.test;

import java.util.HashSet;
import java.util.Set;

public class OddNum {

	
	public static void main(String[] a){
//		for(int i=1;i<=99;i++){
//			if (i%2==0){
//			System.out.print(i+" ");
//			}
//		}
		
		//System.out.println("\n"+countChars("ZZZ Zebra",'Z'));
		System.out.println("\n"+countChar("ZZZ Zebra",-1));
	}
	
//	public static int countChar(String toCount){
//		Set<String> s=new HashSet<String>();
//		int count=0;
//		for (char ch : toCount.toCharArray()) {
//			//System.out.println(ch);
//			if (!s.add(String.valueOf(ch))){
//				count++;
//			}
//		}
//		return count;
//		
//		
//	}
	
	public static int countChar(String toCount,int incr){
		if (incr==toCount.length()-1) {return 0;}
		incr=incr+1;
		System.out.print("incr="+incr+" "+"len="+toCount.length()+" ");
		int result= toCount.substring(incr, toCount.length()-1).contains("Z")?1:0;
		return result+=countChar(toCount.substring(incr, toCount.length()-1),incr);
	}
	
	 public static int countChars(String input,char find){      
         if(input.indexOf(find) != -1){          
         return  countChars(input.substring(0, input.indexOf(find)), find)+ 
             countChars(input.substring(input.indexOf(find)+1),find) + 1;
         }
         else {
             return 0;
         }

     }
}
