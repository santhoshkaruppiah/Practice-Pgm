package test;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {

	public static void shuffle(int[] arrayToShuffle){
		for (int i = 0; i < arrayToShuffle.length; i++) {
			Random random=new Random();
			int randomIndex=random.nextInt(i+1);
			swap(arrayToShuffle, i, randomIndex);
		}
		System.out.println("After="+Arrays.toString(arrayToShuffle));
	}
	
	public static void swap(int[] array,int idx1, int idx2) {
		int temp= array[idx1];
		array[idx1]=array[idx2];
		array[idx2]=temp;
	}
	
	public static void main(String[] args) {
		int arrayToSort1[]={10,11,12,13,14,15,16,17,18,19};
		System.out.println("Before="+Arrays.toString(arrayToSort1));
		shuffle(arrayToSort1);
	}
}
