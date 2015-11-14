package com.code.challenge;

import java.util.Arrays;
import java.util.Scanner;

public class StdInTest {

	public static void main(String[] args) {
		scannerInput();
	}

	public static void scannerInput() {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		System.out.println(len);
		int[][] twoDimArray = new int[len][len];
		int i=0;
		int firstDiaSum=0;
		int secondDiaSum=0;
		while (sc.hasNext()){
			String lineString = sc.nextLine();
			if (lineString==null || lineString.equals("")) continue;
			System.out.println(Arrays.asList(lineString.split(" ")));
			String[] strInt = lineString.split(" ");
			int j=0;
			for (String string : strInt) {
				if(string!=null && !string.equals("")) {
					System.out.println("i="+i+",j="+j);
					twoDimArray[i][j] = Integer.parseInt(string);
					if (isFirstDiagonal(i,j)){firstDiaSum=firstDiaSum+twoDimArray[i][j];}
					j++;
				}
			}
			System.out.println("First Dia. sum="+firstDiaSum);
			if (i+1==len) {
				for(int row=0,col=len-1;row<len;row++,col--){
					secondDiaSum = secondDiaSum+twoDimArray[row][col];
				}
				System.out.println("Sec Dia. sum="+secondDiaSum);
				break;
			}
			i++;
		}
		sc.close();
	}
	
	public static boolean isFirstDiagonal(int firstIdx, int secondIdx){
		return (firstIdx==secondIdx);
	}
	
	public static boolean isSecondDiagonal(int firstIdx, int secondIdx, int len){
		return (firstIdx==secondIdx);
	}
}
