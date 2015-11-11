package com.test;

public class Graphs {
	private final int MAX_VERTS=20;
	private Vertexs vertexList[];
	private int adjMat[][];
	private int nVerts;
	
	public Graphs(){
		vertexList = new Vertexs[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j=0;j<MAX_VERTS;j++)
			for(int k=0;k<MAX_VERTS;k++)
				adjMat[j][k]=0;
	}
	
	public void addVertex(char newLabel){
		vertexList[nVerts++]=new Vertexs(newLabel);
	}
	
	public void addEdge(int start,int end){
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].label);
	}
}


class Vertexs{
	public char label;
	public boolean isVisited;
	
	public Vertexs(char label){
		this.label = label;
		isVisited = false;
	}
}