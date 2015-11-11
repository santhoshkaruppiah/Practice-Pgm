package com.test;

public class SimpleDoubleEndListImpl<T> {
	
	private Link<T> firstLink;
	private Link<T> lastLink;
	
	public void insertFirst(T data){
		
		Link<T> newLink = new Link<T>(data);
		if (firstLink==null)
			lastLink = newLink;
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public void insertLast (T data){
		
		Link<T> newLink = new Link<T>(data);
		if (firstLink==null)
			firstLink = newLink;
		else
			lastLink.next = newLink;
		lastLink = newLink;
	}
	
	public void printList(){
		Link<T> temp = firstLink;
		System.out.println("*** Print List Values ***");
		while(temp!=null){
			System.out.println("List Data Values is="+temp.data);
			temp = temp.next;
		}
	}
	
	public Link<T> deleteFirst(){
		Link<T> temp = firstLink;
		if (firstLink.next==null)
			lastLink = null;
		firstLink = firstLink.next;
		return temp;
	}
	
	public Link<T> deleteLast(){
		Link<T> temp = lastLink;
		Link<T> tmpFrstLk = firstLink;
		while(tmpFrstLk.next!=null){
			tmpFrstLk = tmpFrstLk.next;
		}
		tmpFrstLk = lastLink;
		return temp;
	}
	
	public Link<T> delete(T key){
		Link<T> temp = firstLink;
		while(temp.data!=key){
			temp = temp.next;
		}
		return temp;
	}
	
	public Link<T> find(T key){
		Link<T> temp = firstLink;
		while(temp.data==key){
			temp = temp.next;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		
	}
}

