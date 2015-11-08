package com.test.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList singlyList = new LinkedList();
		singlyList.addNodeToEnd(makeNode("ONE"));
		singlyList.addNodeToEnd(makeNode("TWO"));
		singlyList.addNodeToEnd(makeNode("THREE"));
		singlyList.addNodeToEnd(makeNode("FOUR"));
		//System.out.println(list.getHead().getData());
		System.out.println("AFTER DELETE");
		System.out.println(singlyList.deleteNode(makeNode("TWO")));
		printNode(singlyList.getHead());
		System.out.println("ADD---AGAIN");
		singlyList.addNode(makeNode("TWO"),2);
		printNode(singlyList.getHead());
		singlyList.addNodeToEnd(makeNode("TWO"));
		printNode(singlyList.getHead());
		System.out.println(singlyList.findDupsBuffered());
		printNode(singlyList.getHead());
		singlyList.deleteDupsBuffered();
		System.out.println("After Dups deletion");
		printNode(singlyList.getHead());
	}
	
	static Node makeNode(String data) {
		return new Node(data);
	}
	
	static void printNode(Node toPrint){
		Node tmp= toPrint;
		while (tmp!=null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
	}
}

class LinkedList {
	
	Node head;
	int size=0;
	
	void addNodeToEnd(Node toAdd){
		if (head==null) {
			head=toAdd;
		} else {
			Node tmp = head;
			while(tmp.getNext()!=null){
				tmp = tmp.getNext();
			}
			tmp.next = toAdd;
		}
		size++;
	}
	
	void addNodeAtStart(Node toAdd){
		if(head==null) head = toAdd;
		toAdd.next = head;
		size++;
	}
	
	/**
	 * 
	 * @param toDelete
	 * @return status of delete status
	 */
	
	boolean deleteNode(Node toDelete) {
		boolean result = false;
		//check if head == toDelete node
		if (toDelete.getData()==head.getData()) {
			toDelete.next = head.next;
			head = toDelete.next;
			return true;
		}
		Node current = head;
		while(current.getNext()!=null){
			if (toDelete.getData()==current.getNext().getData()) {
				current.next = current.next.next;
				result = true;
				return result;
			}
			current = current.getNext();
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param toAdd
	 * @param position - Non-Negative, non-zero number
	 */
	void addNode(Node toAdd, int position) {
		
		if (position == 1) {addNodeAtStart(toAdd);}
		if (position >= getSize()) {addNodeToEnd(toAdd);}
		if (position < getSize()) {
			int count=1;
			Node current = head;
			while(current.getNext()!=null) {
				count++;
				if (position==count) {
					toAdd.next =  current.next;
					current.next = toAdd;
				} 
				current = current.getNext();
			}
		}
	}
	
	Map<String,Integer> findDupsBuffered(){
		Map<String,Integer> dupMap = new HashMap<>();
		Node current = head;
		while(current.getNext()!=null) {
			dumpToBuffer(dupMap, current);
			current = current.getNext();
		}
		dumpToBuffer(dupMap, current);
		return dupMap;
	}

	private void dumpToBuffer(Map<String, Integer> dupMap, Node current) {
		if (dupMap.get((String) current.getData())!=null){
			int val = dupMap.get((String) current.getData());
			val++;
			dupMap.put((String) current.getData(), val);
		}else {
			dupMap.put((String) current.getData(), 1);
		}
	}
	
	void deleteDupsBuffered() {
		Set<String> buf = new HashSet<>();
		Node current = head;
		while(current.getNext()!=null) {
			boolean isSuccess = buf.add((String) current.getData());
			if(!isSuccess){
				current.next = current.next.next;
				System.out.println("Dups found");
			}
			current = current.getNext();
		}
		boolean isSuccess = buf.add((String) current.getData());
		if(!isSuccess){
			current.next = current.next.next;
			System.out.println("Dups found");
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public Node getHead() {
		return head;
	}
}

class Node {
	
	private Object data;
	Node next;
	
	Node(String data){
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
}