package com.gayle;

import java.util.HashSet;
import java.util.Set;


public class SingularListOperation {

	public static void addNode(Integer data,SingularNode<Integer> headNode){
		if (headNode==null) {return;}
		SingularNode<Integer> endNode=new SingularNode<Integer>(data);
		while(headNode.getNextNode()!=null){
			headNode=headNode.getNextNode();
		}
		headNode.setNextNode(endNode);
	}
	
	public static void printNode(SingularNode<Integer> headData){
		//SingularNode<Integer> temp=headData;
		while (headData!=null) {
			System.out.println(headData.getData());
			headData=headData.getNextNode();
		}
	}
	
	public static void deleteFirstOccurence(SingularNode<Integer> headData, int dataToDelete){
		SingularNode<Integer> prev=headData;
		while(headData!=null){
			if (dataToDelete==headData.getData()){
				prev.setNextNode(headData.getNextNode());
			}
			prev=headData;
			headData=headData.getNextNode();
		}
		printNode(headData);
	}
	
	public static void removeDups1(SingularNode<Integer> headNode){
		Set<Integer> intSet=new HashSet<Integer>();
		SingularNode<Integer> prev=headNode;
		while(headNode!=null){
			if (!intSet.add(headNode.getData())){
				prev.setNextNode(headNode.getNextNode());
			}
			prev=headNode;
			headNode=headNode.getNextNode();
		}
	}
	
	public static void removeDups2(SingularNode<Integer> headNode){
		if (headNode==null) return;														
		SingularNode<Integer> head = headNode;
		SingularNode<Integer> curr = head.getNextNode();
		while(curr!=null){
			SingularNode<Integer> runner = headNode;
			while(curr!=runner){
				if (curr.getData()==runner.getData()){
					SingularNode<Integer> temp=curr.getNextNode();
					head.setNextNode(temp);
					curr=temp;
					break;
				}
				runner=runner.getNextNode();
			}
			if (curr==runner){
				head = curr;
				curr=curr.getNextNode();
			}
		}
	}
	
	public static void main(String[] args) {
		SingularNode<Integer> headNode=new SingularNode<Integer>(1);
		addNode(8,headNode);
		addNode(8,headNode);
		addNode(5,headNode);
		addNode(7,headNode);
		addNode(6,headNode);
		//printNode(headNode);
		//if (headNode.getData()==1){headNode=headNode.getNextNode();} to del head node
		//deleteFirstOccurence(headNode,7);
		//printNode(headNode);
		//removeDups1(headNode);
		removeDups2(headNode);
		printNode(headNode);
	}
}
