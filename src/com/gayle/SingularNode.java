package com.gayle;

class SingularNode<T>{
	
    private T data; //the data stored in this node
    private SingularNode<T> next; //store a reference to the next node in this singlylinkedlist
    
    public SingularNode(T data){
        this.data = data;
    }

	public T getData() {
		return data;
	}
    
	public void setNextNode(SingularNode<T> nextNode){
		this.next=nextNode;
	}
	
	public SingularNode<T> getNextNode(){
		return next;
	}
}