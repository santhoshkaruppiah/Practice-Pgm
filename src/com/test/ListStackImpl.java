package com.test;

public class ListStackImpl<T> implements StackInterface<T> {

	//LIFO
	
	Node<T> first = null;
	int length = 0;
	
	public ListStackImpl(){
		
	}
	
	public void push(T x) {
		
	}

	public Integer pop() {

		return null;
	}

	public Boolean isEmpty() {
		return null;
	}
	
	private void addFront(T newData) {
		//My implementation--which is not correct ln:"first = prev" is needed to fix it.
		/*if (first==null){
			first = new Node<T>(newData);
			length++;
		}else {
			Node prev  = first;
			first = new Node<T>(newData);
			prev.next = first;
			first = prev;
			length++;
		}*/
		//copied from DS book
		Node newNode = new Node<T>(newData);
		newNode.next = first;
		first = newNode;
		length++;
	}
	
	private Node removeFromLast(){
		/*System.out.println("toBeRemoved::data="+toBeRemoved.data);
		Node nodeToBeRemoved = toBeRemoved.next;
		if (nodeToBeRemoved ==null) {
			System.out.println("removeFromLast:: Node is null");
		} else {
			System.out.println("removeFromLast:: Node is not null");
		}
		toBeRemoved.next = toBeRemoved.next.next;
		return nodeToBeRemoved;*/
		Node temp = first;
		first = first.next;
		return temp;
	} 
	
	private void printStack(){
		Node toPrints = first;
		while (toPrints!=null) {
			System.out.println("Value:"+toPrints.getData());
			toPrints = toPrints.next;
		}
	}
	
	public int listStackLength(){
		return length;
	}
	
	public static void main(String[] args) {
		ListStackImpl<String> obj = new ListStackImpl<String>();
		obj.addFront("one");
		obj.addFront("two");
		int size = obj.listStackLength();
		System.out.println("List based stack length---"+size);
		obj.printStack();
		Node removed = obj.removeFromLast();
		System.out.println("Removed element is ::"+removed.getData());
		size = obj.listStackLength();
		System.out.println("List based stack length---"+size);
		obj.printStack();
	}
}

