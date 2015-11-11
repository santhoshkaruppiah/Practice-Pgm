package com.test;

class Nodes {//Each cell in grid is represented as Nodes
	char name;
	boolean isVisited;
	Nodes(char val){
		this.name = val;
		this.isVisited=false;
	}
}

class DistanceAndPath {//It store the distance from source to adjacent Nodes
	//Initial Values are populated from the pgm,, later algo modify with min values/cost
	int parent;
	int distance;
	
	public DistanceAndPath(int parent, int distance) {
		this.parent = parent;
		this.distance = distance;
	}
}

public class ShortestPath {
	private final int LARGE_NUMBER=10000;
	
	private Nodes nodeList[]; // nde list
	private DistanceAndPath disAndPathObject[]; // array for shortest-path data
	private int adjMat[][];  // adjacency matrix
	private int nIdx;
	private int currentNode;
	private int currentDist;
	private int nodeLen; 

	
	public ShortestPath(int nSize){
		nodeList = new Nodes[nSize];
		adjMat= new int[nSize][nSize]; 
		for(int j=0; j<nSize; j++)	// set adjacency to Large Value initially
			for(int k=0; k<nSize; k++) 
				adjMat[j][k] = LARGE_NUMBER;
		disAndPathObject = new DistanceAndPath[nSize];
	}
	
	public void printAdjMatrix(){
		System.out.println("Print Adj Matrix");
		for(int j=0; j<nIdx; j++){	
			System.out.println();
			for(int k=0; k<nIdx; k++) {
				if (adjMat[j][k]!=LARGE_NUMBER)
					System.out.println("("+nodeList[j].name+","+nodeList[k].name+")= "+adjMat[j][k]);
				else
					System.out.println("("+nodeList[j].name+","+nodeList[k].name+")= INFINITY");
			}
		}
	}
	
	public void calculateShortPath(int startNode){//Dijkstra algo
		nodeList[startNode].isVisited = true; 
		printAdjMatrix();
		// adjMat => disAndPathObject 
		for(int j=0; j<nIdx; j++)
		{
			int tempDist = adjMat[startNode][j]; 
			disAndPathObject[j] = new DistanceAndPath(startNode, tempDist); 
		}
		
		for (int j=0; j<nIdx; j++){
			System.out.println("Parent="+nodeList[disAndPathObject[j].parent].name+",distance="+disAndPathObject[j].distance);
		}
		
		int counter=1;
		while(counter < nIdx){ 
			int minIdx = getMinPath();
			int minDist = disAndPathObject[minIdx].distance;
			if(minDist == LARGE_NUMBER)	{ 	
				System.out.println("Some Nodes cannot be reached"); 
				break;	
			}else {
				currentNode = minIdx;
				currentDist=disAndPathObject[minIdx].distance;
			}
			
			nodeList[minIdx].isVisited = true;
			counter++; 
			updateDisParent();
			System.out.println("Print Shorted Node");
			printPath(startNode);
		}
		
		System.out.println("Printing Shorted to other Nodes FROM "+nodeList[startNode].name);
		printPath(startNode);
		
		//clean up
		counter=0;
		for(int j=0; j<nIdx; j++)
			nodeList[j].isVisited = false;
	}
	
	public void updateDisParent(){
		int col = 1;	
		while(col < nIdx) {	
			if( nodeList[col].isVisited){ 
				System.out.println(nodeList[col].name+",is visited");
				col++; continue; 
			}
			int currentToNxt = adjMat[currentNode][col]; 
			System.out.println("Current Node="+currentNode+",label="+nodeList[currentNode].name+",col="+col+",currentToNxt="+currentToNxt);
			int startToNxt = currentDist + currentToNxt; 
			System.out.println("currentDist:"+currentDist+"+"+"currentToNxt:"+currentToNxt+"="+startToNxt);
			int oDistPth = disAndPathObject[col].distance;
			System.out.println("Label="+nodeList[currentNode].name+",col="+col+",distance="+oDistPth);
			if(startToNxt < oDistPth) 
			{	 
				System.out.println("Label="+nodeList[disAndPathObject[col].parent].name+",col="+col+",updated to parent="+nodeList[currentNode].name+",distance="+startToNxt);
				disAndPathObject[col].parent = currentNode; 
				disAndPathObject[col].distance = startToNxt; 
			}
				col++;
			System.out.println();
		}  
		System.out.println("End update path and distance");
	}
	
	public int getMinPath() {
		int minVal = LARGE_NUMBER; 
		int minIdx = 0; 
		for(int j=1; j<nIdx; j++){
			//System.out.println("j="+j);
			//System.out.println("disAndPathObject[j].distance"+disAndPathObject[j].distance+",minVal="+minVal);
			if( !nodeList[j].isVisited && disAndPathObject[j].distance < minVal ){ 
				minVal = disAndPathObject[j].distance; 
				minIdx = j;	
			}
		}  
		return minIdx;	 
	} 
	
	public void printPath(int startNode){
		System.out.print("\nFrom Node=="+nodeList[startNode].name+"\n");
		for(int j=0; j<nIdx; j++){ 
			System.out.print("To Node::"+nodeList[j].name + "=");  
			if(disAndPathObject[j].distance == LARGE_NUMBER)
				System.out.print("UNDEFINED");	 
			else
				System.out.print(disAndPathObject[j].distance); 
			char parent = nodeList[ disAndPathObject[j].parent ].name; 
			System.out.print(" via..(" + parent + ") [the last node to reach this point] \n" );	
			}
		System.out.println("");
	}
	
	public void addNode(char name){
		nodeList[nIdx++] = new Nodes(name);
	}
	
	public void addEdge(int start,int end,int weight,boolean isConnected){
		if (isConnected)
			adjMat[start][end]=weight;
	}
	
	public static void main(String s[]){
		ShortestPath shPathObj = new ShortestPath(20);
		/**
		 * Use addNode to set the Nodes... 
		 * In terms of problem statement, assume each node corresponds to a cell in grid
		 */
		
		shPathObj.addNode('A'); //0 (start)
		shPathObj.addNode('B'); //1
		shPathObj.addNode('C'); //2
		shPathObj.addNode('D'); //3
		shPathObj.addNode('E'); //4
		
		/**
		 * Use addEdge to define connectivity between Nodes... If Nodes cannot be connected, don't make a entry
		 * First Param--Denotes starting Node
		 * Second Param--Denotes End Node
		 * Third Param-- Shows the weight/cost to move between First Node and Second Node
		 * Fourth Param-- Boolean flag to denote, if mentioned node should be connected
		 */
		shPathObj.addEdge(0, 1, 50,true);//AB 50
		shPathObj.addEdge(0, 3, 80,true);//AD 80
		shPathObj.addEdge(1, 2, 60,true);//BC 60
		shPathObj.addEdge(1, 3, 90,true);//BD 90
		shPathObj.addEdge(2, 4, 40,true);//CE 40
		shPathObj.addEdge(3, 2, 20,true);//DC 20
		shPathObj.addEdge(3, 4, 70,true);//DE 70
		shPathObj.addEdge(4, 1, 50,true);//EB 50
		System.out.println("Shortest paths: ");
		int startNode = 0;
		/***
		 * dijkstra algorithm to calculate shortest path from start Node to all other nodes
		 */
		shPathObj.calculateShortPath(startNode);
		System.out.println();
	}
}
