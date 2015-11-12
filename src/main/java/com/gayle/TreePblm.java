package com.gayle;

public class TreePblm {

	
	
	
	
	public TreeNds constructNode(){
		TreeNds rootNode=new TreeNds("A");
		TreeNds rootLeftNode=new TreeNds("B");
		TreeNds rootRightNode=new TreeNds("C");
		TreeNds secRightNode=new TreeNds("D");
		TreeNds secLeftNode=new TreeNds("E");
		rootNode.setLeft(rootLeftNode);
		rootNode.setRight(rootRightNode);
		rootNode.getLeft().setLeft(secLeftNode);
		rootNode.getRight().setRight(secRightNode);
		return rootNode;
	}
	
}

class TreeNds{
	
	private Object data;
	private TreeNds left;
	private TreeNds right;
	
	public TreeNds(Object data){
		this.data = data;
	}

	public TreeNds getLeft() {
		return left;
	}

	public void setLeft(TreeNds left) {
		this.left = left;
	}

	public TreeNds getRight() {
		return right;
	}

	public void setRight(TreeNds right) {
		this.right = right;
	}
	
}