package test;

public class CopyOfTryRecBinTree {

	static  int totNodes=3;
	static final int lNodesCnt=1;
	static final int rNodesCnt=1;
	static  int lCounter=0,rCounter=0;
	
	public static Node addNodeRecursive(){
		if (totNodes==0 || (lCounter>lNodesCnt && rCounter>rNodesCnt))
			return null;
		Node ref=new Node();
		ref.data=totNodes;
		totNodes--;
		lCounter++;
		ref.lChild=addNodeRecursive();
		rCounter++;
		ref.rChild=addNodeRecursive();
		return ref;
	} 
	
	
	static int inc(int in)
    {//guess,,, this makes trick
        assert in < Integer.MAX_VALUE;
        return (in + 1);
    }
	
	public static void main(String[] args) {
		System.out.println("sdcvj");
		Node root=addNodeRecursive();
		if (root!=null) {
			System.out.println(root.data);
			if (root.lChild!=null) {
				System.out.println(root.lChild.data);
			}
			if (root.rChild!=null){
				System.out.println(root.rChild.data);
			}
		}
	}

	static class Node{
		Object data;
		Node lChild;
		Node rChild;
	}
	
	static class Leaf extends Node {
		
	}
	
}


