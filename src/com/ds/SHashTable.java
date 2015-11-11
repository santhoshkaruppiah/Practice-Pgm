package com.ds;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class SHashTable<K,V> {//HashTable with seperate chaining
	
	private LinkedList<Node<K,V>>[] dataArr;
	private int size;
	
	SHashTable(int size){
		try {
			dataArr=new LinkedList[size];
			this.size = size;
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public boolean put(K key,V val){
		boolean isPut=false;
		Node<K,V> data=new Node<K,V>(key,val);
		assert hashFunc(key, size)<0:"hash func is returning zero";
		LinkedList<Node<K,V>> list=(dataArr[hashFunc(key, size)]==null)?new LinkedList<Node<K,V>>() :dataArr[hashFunc(key, size)];
		list.add(data);
		dataArr[hashFunc(key, size)]=list;
		isPut=true;
		return isPut;
	}
	
	public V get(K key){
		LinkedList<Node<K,V>> list=(dataArr[hashFunc(key, size)]==null)?new LinkedList<Node<K,V>>() :dataArr[hashFunc(key, size)];
		V val=(V) "";
		for (Node<K, V> node : list) {
			if (node.getKey()==key){
				val= node.getVal();
				break;
			}
		}
		return val;
	}
	
	public boolean remove(K key){
		
		boolean isRemoved= false;
		LinkedList<Node<K,V>> list=dataArr[hashFunc(key, size)];
		if (list!=null){
			for (Node<K, V> node : list) {
				if (node.getKey().equals(key)){
					list.remove(node);
					isRemoved = true;
					break;
				}
			}
			
		}
		return isRemoved;
	}
	
	private static <K> int getHashCode(K key){
		int hashCode=2;
		
		if (key instanceof String){
			int val=0;
			for (int idx = 0; idx < ((String) key).length(); idx++) {
				val+=((String)key).charAt(idx)*pow(26,idx);
			}
			hashCode=val;
		}else{
			return 1;
		}
		
		return hashCode;
	}
	
	private static <K> int hashFunc(K key,int size){
		return getHashCode(key)%size;
	}
	
	public static void main(String[] args) {
		SHashTable<String,String> testHashTb= new SHashTable<String,String>(40);
		testHashTb.put("name", "santhosh");
		testHashTb.put("job", "pgmer");
		System.out.println("is removed="+testHashTb.remove("name"));
		System.out.println("RESULT=="+testHashTb.get("job"));
		System.out.println(testHashTb.size);
//		for (LinkedList<Node<String, String>> val : testHashTb.dataArr) {
//			if (val!=null){
//			val.peek().printValue();
//			}else{
//				System.out.println("Linked List value is null");
//			}
//		}
		//System.out.println(pow(2,4));
		//System.out.println(getHashCode("santhosh"));
		//System.out.println(hashFunc("santhosh",40));
	}
	
	public static double pow(int base,int power){
		double val=1,counter=1;
		if (power==0) return val=0;
		while(counter<=power){
			val=val*base;
			counter++;
		}
		return val;
	}

	public int getSize() {
		return size;
	}
	
	
}

class Node<K, V>{
	private K key;
	private V val; 
	Node(K key,V val){
		this.key=key;
		this.val=val;
	}
	
	public void printValue(){
		System.out.println("Key="+key+",Val="+val);
	}

	public K getKey() {
		return key;
	}

	public V getVal() {
		return val;
	}

}