package test;

import java.util.Random;

public class TryRecBinTree {

	static final int height=3;
	static  int depth=0;
	static int recCounter=1;
	
	public static AbstractNode addNodeRec(int depth){
		System.out.println("Depth-rec="+depth+" ,recCounter="+recCounter);
		recCounter++;
		if (height==depth){
			Leaf l=new Leaf();
			l.data="Leaf--Val="+new Random().nextInt();
			return l;
		}
		AbstractNode l=addNodeRec(inc(depth));
		l.data="left Node, val="+new Random().nextInt();
		AbstractNode r=addNodeRec(inc(depth));
		r.data="right Node, val="+new Random().nextInt();
		Node res= new Node();
		res.data="Node, val="+new Random().nextInt();
		res.lChild=l;
		res.rChild=r;
		return res;
	}
	
	static int inc(int in)
    {//guess,,, this makes trick
        assert in < Integer.MAX_VALUE;
        return (in + 1);
    }
	
	public static void main(String[] args) {
		System.out.println("Depth-Init="+depth);
		AbstractNode ab=addNodeRec(depth);
		System.out.println("Depth-final="+depth);
		preOrderTraversal(ab);
	}

	public static void preOrderTraversal(AbstractNode root){
		if( root == null ) return;
		System.out.println(root.data);; 
		preOrderTraversal(root.lChild ); 
		preOrderTraversal(root.rChild );
	}
	
	static abstract class AbstractNode{
		Object data;
		AbstractNode lChild;
		AbstractNode rChild;
	}
	
	static class Node extends AbstractNode{
		
	}
	
	static class Leaf extends Node {
		
	}
	
}


