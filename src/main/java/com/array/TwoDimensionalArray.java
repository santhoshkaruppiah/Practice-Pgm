package com.array;


public class TwoDimensionalArray {

	public static void main(String[] args) {
//		makeArray(2,2);
//		makeArray(2,3);
//		makeArray(1,1);
//		//makeArray(0,0);//arg are 1 based, <=0 # are not permitted
//		makeArray(10,10);
//		makeArray(4,4);
		//rotate_Vgayle(rotate_Vgayle(makeArray(4,4),4),4);
		rotate_Vgayle(rotate_Vgayle(makeArray(5,5),5),5);
	}
	
	public static int[][] makeArray(int row,int col) {
		int[][] twoDArr = new int[row][col];
		int i=1;
		for (int rowIdx = 0; rowIdx < twoDArr.length; rowIdx++) {
			for (int colIdx = 0; colIdx < twoDArr[0].length; colIdx++) {
				twoDArr[rowIdx][colIdx]=i++;
			}
		}
		printGrid(twoDArr);
		return twoDArr;
	}
	
	public static void printGrid(int[][] twoDArr)
	{
		System.out.println("Print matrix, size="+twoDArr.length+"x"+twoDArr[0].length);
	   for(int i = 0; i < twoDArr.length; i++) {
	      for(int j = 0; j < twoDArr[0].length; j++)
	      {
	         System.out.printf("%5d ", twoDArr[i][j]);
	      }
	      System.out.println();
	   }
	}
	
	/**
	 * 
	 * @param matrix, is NxN matrix
	 * @param n should be <=matrix.length
	 * to rotate 45˚ n=matrix.length
	 * 
	 * To rotate by various degress, use nested expression
	 * for ex: for 90˚ rotation, use "rotate_Vgayle(rotate_Vgayle(makeArray(4,4),4),4);"
	 */
	
	public static int[][] rotate_Vgayle(int[][] matrix, int n) {
		System.out.println("Rotate by="+4);
		for (int layer = 0; layer < n / 2; ++layer) {
			int  rst = layer;
			int last=n-1-layer;
			for(int i =  rst; i < last; ++i) {
				int offset = i -  rst;
				int top = matrix[rst][i]; // save top
				// left -> top
				matrix[ rst][i] = matrix[last-offset][rst];
				// bottom -> left
				matrix[last-offset][rst] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top; // right <- saved top }
			} 
		}
		printGrid(matrix);
		return (matrix);
	}
	
}
