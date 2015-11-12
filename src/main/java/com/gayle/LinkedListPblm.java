package com.gayle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;


public class LinkedListPblm {

	public static void main(String[] args) {
		//deleteDup_Sol1(consCustomlList());
		//deleteDup_Sol2(consCustomNode());
//		printNode(addList(consList1(), consList2(), 0));
//		printNode(consLoopList());
		//printNode(findMulitRefNode(consLoopList()));
		com.test.Node result=findMulitRefNode(consLoopList());
		while(result!=null){
			System.out.print(result.data+" ");
			result=result.next;
		}
		
	}
	
	public static com.test.Node findMulitRefNode(com.test.Node toFind){
		com.test.Node fastPointer=toFind;
		com.test.Node slowPointer=toFind;
		while(fastPointer.next!=null){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
			if (slowPointer==fastPointer){
				break;
			}
		}
		
		if (fastPointer==null){return null;}
		slowPointer=toFind;
		while(slowPointer!=fastPointer){
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
		}
		
		return fastPointer;
		
	}
	
	public static void deleteDup_Sol1(LinkedList toDeleteList){//remove duplicate from unsorted linked list
															//sol--with temp buffer or no buffer
		//**this sol. is with extra buffer**
		Map hMap=new HashMap();
		System.out.println("Size="+toDeleteList.size());
		ListIterator itr=toDeleteList.listIterator(0);
		while(itr.hasNext()){
			Node curr=(Node)itr.next();
			System.out.println("Curr Node Value="+curr.getSData());
			if (!hMap.containsKey(curr.getSData())){
				hMap.put(curr.getSData(), true);
			}else{
				itr.remove();
			}
		}
		printLinkedList(toDeleteList);
		
	}
	
	public static void deleteDup_Sol2(com.test.Node toDeleteList){//remove duplicate from unsorted linked list
																  //sol-- with no buffer
		if (toDeleteList==null) return;														
		com.test.Node head = toDeleteList;
		com.test.Node curr = head.next;
		while(curr!=null){
			com.test.Node runner = toDeleteList;
			while(curr!=runner){
				if (curr.data==runner.data){
					com.test.Node temp=curr.next;
					head.next=temp;
					curr=temp;
					break;
				}
				runner=runner.next;
			}
			if (curr==runner){
				head = curr;
				curr = curr.next;
			}
		}
		
		printNode(toDeleteList);

	}
	
	//find kth to last element of a singly linked list
	//delete Node in middle of singly linked list, given access to only to that node
	//partion linked list around value x, such that all values less than comes before all nodes greater or equal to x
	
	public static void printLinkedList(LinkedList toPrint){
		int i=0;
		for (Object object : toPrint) {
			Node ref=(Node)object;
			System.out.println("Node "+i+",data="+ref.getSData());
			i++;
		}
	}
	
	public static LinkedList consCustomlList(){
		LinkedList toReturnlList = new LinkedList();
		toReturnlList.add(new Node("one"));
		toReturnlList.add(new Node("two"));
		toReturnlList.add(new Node("three"));
		toReturnlList.add(new Node("one"));
		toReturnlList.add(new Node("three"));
		toReturnlList.add(new Node("two"));
		toReturnlList.add(new Node("four"));
		return toReturnlList;
	}
	
	public static com.test.Node addList(com.test.Node<Integer> node1,com.test.Node<Integer> node2,int carry){
		if (node1==null && node2==null) { return null;}
		int nodeData=(node1.data+node2.data+carry)%10;
		com.test.Node root=new com.test.Node(nodeData);
		com.test.Node<Integer> chldNode=addList(node1.next,node2.next,node1.data+node2.data>=10?1:0);
		root.next=chldNode;
		return root;
	}
	
	public static void printNode(com.test.Node toPrint){
		com.test.Node temp=toPrint;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}

	public static com.test.Node consCustomNode(){
		com.test.Node<Integer> root = new com.test.Node<Integer>(1);
		root.next=new com.test.Node<Integer>(2);
		root.next.next=new com.test.Node<Integer>(3);
		root.next.next.next=new com.test.Node<Integer>(2);
		root.next.next.next.next=new com.test.Node<Integer>(1);
		return root;
	}
	
	public static com.test.Node consList1(){
		com.test.Node<Integer> root = new com.test.Node<Integer>(3);
		root.next=new com.test.Node<Integer>(1);
		root.next.next=new com.test.Node<Integer>(5);
		return root;
	}
	
	public static com.test.Node consList2(){
		com.test.Node<Integer> root = new com.test.Node<Integer>(5);
		root.next=new com.test.Node<Integer>(9);
		root.next.next=new com.test.Node<Integer>(3);
		return root;
	}
	
	public static com.test.Node consLoopList(){
		com.test.Node<Integer> root = new com.test.Node<Integer>(1);
		com.test.Node<Integer> ch1 = new com.test.Node<Integer>(2);
		com.test.Node<Integer> ch2 = new com.test.Node<Integer>(3);
		com.test.Node<Integer> ch3 = new com.test.Node<Integer>(4);
		com.test.Node<Integer> ch4 = new com.test.Node<Integer>(5);
		com.test.Node<Integer> ch5 = new com.test.Node<Integer>(6);
		com.test.Node<Integer> ch6 = new com.test.Node<Integer>(7);
		com.test.Node<Integer> ch7 = new com.test.Node<Integer>(8);
		root.next=ch1;
		ch1.next=ch2;
		ch2.next=ch3;
		ch3.next=ch4;
		ch4.next=ch5;
		ch5.next=ch6;
		ch6.next=ch7;
		ch7.next=ch4;
		return root;
	}
}

class Node{
	private String sData;
	
	Node(String sData){
		this.sData = sData;
	}
	
	public String getSData(){
		return sData;
	}
}