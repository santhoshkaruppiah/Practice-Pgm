package com.test;

import java.util.Stack;

public class Tree<T extends Number> {

	private TreeNode<Integer> root;
	
	public TreeNode<Integer> find(Integer key){
		TreeNode<Integer> current = root;
		while(current.data!=key){
			if (key<(Integer)current.data){
				current = current.leftTree;
			}else{
				current = current.rightTree;
			}
			
			if (current==null)
				return null;
		}
		return current;
	}
	
	public void insert(Integer data){
		TreeNode<Integer> newNode = new TreeNode<Integer>(data);
		newNode.data = data;
		if (root ==null){
			root= newNode;
		}else{
			TreeNode<Integer> current = root;
			TreeNode<Integer> parent;
			while(true){
				parent=current;
				if (data<(Integer)current.data){//go left
					current = current.leftTree;
					if (current==null){
						parent.leftTree = newNode;
						return;
					}
				}else{//go right [either "data" is equal or > then current.data]
					current = current.rightTree;
					if (current==null){
						parent.rightTree = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * Input Tree
	 *  4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 0.5,1,2,3,4,5
	 * Call itself to traverse the node’s left subtree. 
	 * Visit the node. 
	 * Call itself to traverse the node’s right subtree.
	 */
	public void inOrderTraversal_REC_BOOKImpl1(TreeNode<Integer> root){
		if (root!=null) {
			inOrderTraversal_REC_BOOKImpl1(root.leftTree);
			root.displayTreeNode();
			inOrderTraversal_REC_BOOKImpl1(root.rightTree);
		}
	}
	
	/**
	 * Input Tree
	 *  4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 0.5,1,2,3,4,5
	 * Call itself to traverse the node’s left subtree. 
	 * Visit the node. 
	 * Call itself to traverse the node’s right subtree.
	 */
	public void inOrderTraversal_REC_MYImpl1(TreeNode<Integer> root){
		if (root==null) return;
		inOrderTraversal_REC_MYImpl1(root.leftTree);
		root.displayTreeNode();
		inOrderTraversal_REC_MYImpl1(root.rightTree);
	}
	
	/**
	 * Input Tree
	 *  4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 0.5,1,2,3,4,5
	 * Call itself to traverse the node’s left subtree. 
	 * Visit the node. 
	 * Call itself to traverse the node’s right subtree.
	 */
	public void inOrderTraversal_itr_myImpl2(){
		if (root==null) return;
		TreeNode<Integer> current = root;
		Stack<Object> inOrderStack = new Stack<Object>();
		inOrderStack.add(current);
		getAllLeftOrRightObject_InOrder(current.leftTree,inOrderStack);
		while(!inOrderStack.isEmpty()){
			TreeNode<Integer> toProcess=(TreeNode<Integer>)inOrderStack.pop();
			processNode(toProcess);
			TreeNode<Integer> rightNode = toProcess.rightTree;
			getAllLeftOrRightObject_InOrder(rightNode,inOrderStack);
		}
	}
	
	public void getAllLeftOrRightObject_InOrder(TreeNode<Integer> leftOrRight,Stack<Object> toAdd){
		while (leftOrRight!=null){
			toAdd.add(leftOrRight);
			leftOrRight = leftOrRight.leftTree;
		}
	}
	
	public void processNode(TreeNode<Integer> toProcess){
		toProcess.displayTreeNode();
	}
	
	/**
	 * BUGGY IMPL,, didn't understand the problem/steps.. it never visit all left subtree fully [which is supposed to be done]
	 * It just goes left, print it , then go right print it, then from that right it traverse all left/right depending on null condition...
	 * essentially this impl is a crap...;.; 
	 * Input Tree
	 *  4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 0.5,1,2,3,4,5
	 * Call itself to traverse the node’s left subtree. 
	 * Visit the node. 
	 * Call itself to traverse the node’s right subtree.
	 */
	public void inOrderTraversal_itr_myImpl1(){
		if (root==null) return;
		TreeNode<Integer> current = root;
		while(current!=null){
			current=current.leftTree;
			current.displayTreeNode();
			current=current.rightTree;
			current.displayTreeNode();
		}
		
	}
	
	/**
	 *Input Tree::
	 * 	 4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 
    	*1.Visit the node. 
	    *2.Call itself to traverse the node’s left subtree. 
	    *3.Call itself to traverse the node’s right subtree.
	 */
	public void preOrderTraversal_REC_myImpl1(TreeNode<Integer> root){
		if (root!=null) {
			processNode(root);
			preOrderTraversal_REC_myImpl1(root.leftTree);
			preOrderTraversal_REC_myImpl1(root.rightTree);
		}
		
	}
	
	/**
	 *Input Tree::
	 * 	 4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 
    	*1.Visit the node. 
	    *2.Call itself to traverse the node’s left subtree. 
	    *3.Call itself to traverse the node’s right subtree.
	 */
	public void preOrderTraversal_itr_myImpl2(){
		if (root==null) return;
		TreeNode<Integer> current = root;
		Stack<Object> preOrderStack = new Stack<Object>();
		processNode(current);
		preOrderStack.add(current);
		preOrder_getAllLeftOrRightObject(current.leftTree,preOrderStack);
		while (!preOrderStack.isEmpty()) {
			TreeNode<Integer> toProcess=(TreeNode<Integer>)preOrderStack.pop();
			TreeNode<Integer> rightTree=toProcess.rightTree;
			preOrder_getAllLeftOrRightObject(rightTree, preOrderStack);
		}
		
	}
	
	public void preOrder_getAllLeftOrRightObject(TreeNode<Integer> leftOrRight,Stack<Object> toAdd){
		while (leftOrRight!=null){
			processNode(leftOrRight);
			toAdd.add(leftOrRight);
			leftOrRight = leftOrRight.leftTree;
		}
	}
	
	/**
	 * BUGGY IMPL: This impl does not meet/follow steps mentioned
	 * It display first left, then goes right and displays all its child based on null check.
	 *Input Tree::
	 * 	 4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 
    	*1.Visit the node. 
	    *2.Call itself to traverse the node’s left subtree. 
	    *3.Call itself to traverse the node’s right subtree.
	 */
	public void preOrderTraversal_itr_myImpl1(){
		if (root==null) return;
		TreeNode<Integer> current = root;
		while(current!=null){
			current.displayTreeNode();
			current=current.leftTree;
			current.displayTreeNode();
			current=current.rightTree;
			current.displayTreeNode();
		}
	}
	
	/**
	 * 
	 *Input Tree::
	 * 	 4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 
	 * 1.Call itself to traverse the node’s left subtree. 
	 * 2.Call itself to traverse the node’s right subtree. 
	 * 3.Visit the node.
	 */
	
	public void postOrderTraversal_REC_myImpl2(TreeNode<Integer> root){
		if (root!=null){
			postOrderTraversal_REC_myImpl2(root.leftTree);
			postOrderTraversal_REC_myImpl2(root.rightTree);
			processNode(root);
		}
		
	}
	
	/**
	 * 
	 *Input Tree::
	 * 	 4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 
	 * 1.Call itself to traverse the node’s left subtree. 
	 * 2.Call itself to traverse the node’s right subtree. 
	 * 3.Visit the node.
	 */
	
	public void postOrderTraversal_itr_myImpl2(){
		if (root==null) return;
		TreeNode<Integer> current = root;
		
	}
	
	public void postOrder_getAllLeftOrRightObject(TreeNode<Integer> leftOrRight,Stack<Object> toAdd){
		while (leftOrRight!=null){
			toAdd.add(leftOrRight);
			leftOrRight = leftOrRight.leftTree;
		}
	}
	
	/**
	 * BUGGY IMPL:: Impl never follow outlined points
	 *Input Tree::
	 * 	 4
	 	/\
	   2  5
	  /\	   
	 1	3
	/
	0.5
	OUTPUT::: 
	 * 1.Call itself to traverse the node’s left subtree. 
	 * 2.Call itself to traverse the node’s right subtree. 
	 * 3.Visit the node.
	 */
	public void postOrderTraversal_itr_myImpl1(){
		if (root==null) return;
		TreeNode<Integer> current = root;
		while(current!=null){
			current=current.leftTree;
			current.displayTreeNode();
			current=current.rightTree;
			current.displayTreeNode();
		}
	}
	
	public void delete(T id){
		
	}
	
	
	public int heightOfBinaryTree(TreeNode<Integer> node)
	{
	    if (node == null)
	    {
	        return 0;
	    }
	    else
	    {
	        return 1 +
	        Math.max(heightOfBinaryTree(node.leftTree),
	            heightOfBinaryTree(node.rightTree));
	    }
	}
	

	public static void main(String[] d){
		Tree s=new Tree();
		s.insert(4);
		s.insert(2);
		s.insert(5);
		s.insert(1);
		s.insert(3);
		s.insert(0);
		System.out.println(s.heightOfBinaryTree(s.root));
	}
}
