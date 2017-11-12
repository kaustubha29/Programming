package SecondBase;

import java.io.*;

public class Islands{
	


	static boolean isSafeMove(int[][] arr, boolean[][] visited, int R, int C, int nextRow, int nextCol){
		return (nextRow>=0 && nextCol>=0 && nextRow<R && nextCol<C && arr[nextRow][nextCol]==1 && !visited[nextRow][nextCol]);
	}

	static int numIslands(int[][] arr){
		int R=arr.length;
		int C=arr[0].length;
		int count=0;
		boolean[][] visited = new boolean[R][C];
		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++)
				visited[i][j]=false;
		}

		for(int i=0;i<R;i++){
			for(int j=0;j<C;j++){
				if(!visited[i][j] && arr[i][j]==1){
					numIslandsHelper(arr,visited,R,C,i,j);
					count++;
				}
			}
		}
		
		return count;
	}
	
	static int Move[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
	
	static void numIslandsHelper(int[][]arr, boolean[][]visited,int R, int C, int i, int j){
		visited[i][j]=true;
		//8 neighbours 
		for(int mi=0;mi<8;mi++){
			int nextRow=i+Move[mi][0];
			int nextCol=j+Move[mi][1];
			if(isSafeMove(arr,visited,R,C,nextRow,nextCol) && !visited[nextRow][nextCol]){
				numIslandsHelper(arr,visited,R,C,nextRow,nextCol);
			}
		}
	}

	public static void main(String[] args){
		int[][] arr= {{1, 1, 0, 0, 0},
                      {0, 1, 0, 0, 1},
                      {1, 1, 0, 1, 1},
                      {0, 0, 0, 0, 0},
                      {1, 0, 1, 0, 1}};
    	System.out.print("No. of Islamnds :: "+ numIslands(arr));
	}
				
}