package com.test;

class TreeNode<T extends Number> {
	
	/**
	 * intentinally made all instance var public, just for easiness
	 */
	
	public T data;
	public TreeNode<T> leftTree;
	public TreeNode<T> rightTree;
	public boolean isVisited;
	
	public TreeNode(T data){
		this.data = data;
	}
	
	public void displayTreeNode(){
		System.out.println("*** TreeNode All Values ***");
		System.out.println("Value of data="+data);
		
		if (leftTree==null){
			
		}else{
			
		}
		
		if (rightTree==null){
			
		}else{
			
		}
	}
	
	public void displayTreeNodeValueOnly(){
		System.out.println("*** TreeNode Data Values Only***");
		System.out.println("Value of data="+data);
	}
}
