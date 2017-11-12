package SecondBase;

import java.io.*;

public class Search{
	
	public static boolean linearSearch(int[] arr, int n){
		for (int i=0;i<arr.length;i++){
			if (arr[i]==n) return true;
		}
		return false;
	}

	public static boolean binarySearch(int[]arr,int n){
		return binarySearchHelper(arr,0,arr.length-1,n);
	}
	public static boolean binarySearchHelper(int[]arr,int l, int r, int n){
		if(r>=l){
			int mid=l+(r-l)/2;
			if (arr[mid]==n)
				return true;
			if (arr[mid]>n)
				return binarySearchHelper(arr,l,mid-1,n);
			else
				return binarySearchHelper(arr,mid+1,r,n);
		}
		return false;
	}

public static void main(String[] args){
		Array a= new Array();
		int[] arr={1,2,3,4,5,6};
		a.printArray(arr);
		//System.out.print(" Present ? : " + linearSearch(arr,6));
		System.out.print(" Present ? : " + binarySearch(arr,6));


	}
}