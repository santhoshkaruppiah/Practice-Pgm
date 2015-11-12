package com.test;

import java.lang.reflect.Array;

public class ArrayStackImpl<T> implements StackInterface<T> { 
	
	private T[] array;
	private int idx;
	@SuppressWarnings("unchecked")
	public ArrayStackImpl(T arg,int size){
		this.array = (T[]) Array.newInstance(arg.getClass(), size);
		this.idx = -1;
		//array[0] = (T) "I am there";
		//System.out.println("ArrayStackImpl CONST,array[0]="+array[0]);
	}

	public Integer pop() {
		if (idx!=-1) {
			int temp = idx;
			array[idx--]=null;
			return temp;
		}else {
			return -1;
		}
	}

	public Boolean isEmpty() {
		return idx==-1;
	}
	
	public int getArrayLength(){
		return array.length;
	}
	
	public void push(T x) {
		if (idx==array.length-1) {
			System.out.println("Push Operation:: Array length is -1. Not able to insert");
		}else {
			//System.out.println("Push Operation:: Inserting Object="+x.toString()+" into array, idx="+idx);
			array[++idx] = x;
			//System.out.println("Push Operation:: idx="+idx);
		}
	}
	
	public void printArray(){
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("Idx="+i+", array value="+array[i]);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayStackImpl obj = new ArrayStackImpl<String>("Hi",10);
		System.out.println("Array Length-After Creation"+obj.getArrayLength());
		for (int i = 0; i < 10; i++) {
			obj.push(String.valueOf(i+1));
		}
		obj.printArray();
		System.out.println("removed element @ idx"+obj.pop());
		System.out.println("Array Length-After Removal"+obj.getArrayLength());
	}
}
