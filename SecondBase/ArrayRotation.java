package SecondBase;


import java.io.*;
import java.util.*;

public class ArrayRotation {
	
	public static void displayleftRotate(int[] input, int d){
		int count = input.length;
		while(count >0 ){
			System.out.print(input[d%input.length] +" ");
			d++;
			count--;
		}
		System.out.println();
	}

	public static void storeLeftRotate(int[] input, int d){
		for (int i=0;i<d;i++){
			leftRotateByOne(input);
		}
	}
	
	public static void leftRotateByOne(int[] input){
		int temp=input[0];
		int i=0;
		for(i=0;i<input.length-1;i++){
			input[i]=input[i+1];
		}
		input[i]=temp;
	}


	public static void reverseArray(int[] input, int start, int end){
		int temp;
		while (start < end){
			temp=input[start];
			input[start]= input[end];
			input[end]=temp;
			start++;end--;
		}

	}

	public static void reverseRotateArray(int[] input, int d){
		reverseArray(input,0,d-1);
		reverseArray(input,d,input.length-1);
		reverseArray(input,0,input.length-1);
	}

	
	
	public static void main(String[] args){
		Array a= new Array();
		int[] arr=a.createArray(7);
		a.printArray(arr);
		displayleftRotate(arr,3);
		reverseRotateArray(arr,3);
		a.printArray(arr);

	}

}

