package SecondBase;

import java.util.*;
import java.io.*;

public class TDArray{

	public static void printDiagonalNN(int[][] arr){
		
		int n = arr.length;	
		for(int d=0;d<2*n;d++){
			for(int i=0;i<=d;i++){
				if(i<n && d-i <n)
				System.out.print(arr[i][d-i]+" ");
			}
		}
	}


	public static void printDiagonalSlice(int[][] arr){
		
		int C = arr[0].length;
		int R = arr.length;
		for(int d=0;d<R+C;d++){
			for(int i=0;i<=d;i++){
				if(i<R && d-i <C)
				System.out.print(arr[i][d-i]+" ");
			}
			System.out.println();
		}
	}

	public static void printSpiral(int[][] arr){
		int startRow,startCol, endRow, endCol;
		int R=arr.length;
		int C=arr[0].length;

		startRow=0;endRow=R;
		startCol=0;endCol=C;
		//int i;

		while(startRow<endRow && startCol<endCol){
			for(int i=startCol;i<endCol;++i)
				System.out.print(arr[startRow][i] + " ");
			startRow++;

			for(int i=startRow;i<endRow;++i)
				System.out.print(arr[i][endCol-1]+ " ");
			endCol--;

			if(startRow<endRow){
				for(int i=endCol-1;i>=startCol;--i)
					System.out.print(arr[endRow-1][i]+ " ");
				endRow--;
			}	
			if(startCol<endCol){
				for(int i=endRow-1;i>=startRow;--i)
					System.out.print(arr[i][startCol]+ " ");
				startCol++;
			}
		}

	}


	public static void main(String[] args){
		int a[][]={{1,2,3},
				   {4,5,6},
				   {7,8,9},
				   {10,11,12}};

		// int a[][]={{1,2,3,4},
		// 		   {5,6,7,8},
		// 		   {9,10,11,12}};
		// //printDiagonalNN(a);
		System.out.println("Diagonal SLice");printDiagonalSlice(a);
		System.out.println("Spiral");printSpiral(a);
	}
}