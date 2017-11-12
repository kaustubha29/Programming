package SecondBase;

import java.io.*;

//O(logn)

public class Frequency{
	
	public static int frequency(int[] arr, int n){
		int first = firstOccurance(arr,0,arr.length-1,n);
		if (first == -1)
			return 0;
		int last = lastOccurance(arr,first,arr.length-1,n);
		System.out.println("First " + first);
		System.out.println("Last " + last);
		return last-first+1 ;
	}

	static int firstOccurance(int[] arr, int low, int high, int n){
		int mid = (low+high)/2; // low + (high-low)/2
		if(high>=low){
			if (arr[mid]==n && ( mid==0 || arr[mid-1]<n))
				return mid;
			else if(n > arr[mid])
				return firstOccurance(arr,mid+1,high,n);
			else
				return firstOccurance(arr,low,mid-1,n);
		}
		return -1;	
	}

	static int lastOccurance(int[] arr, int low, int high, int n){
		int mid = (low+high)/2;
		if(high>=low){
			if (arr[mid] == n && (mid==arr.length-1 || n<arr[mid+1]))
				return mid;
			else if(n < arr[mid])
				return lastOccurance(arr,low,mid-1,n);
			else
				return lastOccurance(arr,mid+1,high,n);
		}
		return -1;
	}

	public static void main(String[] args){
		Array a= new Array();
		int[] arr={1, 2, 2, 3, 3, 3, 3,4};
		a.printArray(arr);
		int in=4;
		System.out.println("Freq of : "+ in +" is "+ frequency(arr,in));
	}

}