package com.test;

public class Node<T>{
	
    public T data; //the data stored in this node
    public Node<T> next; //store a reference to the next node in this singlylinkedlist
    
    public Node(T data){
        this.data = data;
    }

	public T getData() {
		return data;
	}
    
}