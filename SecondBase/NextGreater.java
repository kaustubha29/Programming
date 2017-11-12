package SecondBase;

import java.util.*;
import java.io.*;

public class NextGreater{
	
	public static void getNextGreaterV1(int[] in){
		int n=in.length;
		int next;
		for (int i=0;i<n;i++){
			next = -1;
			for (int j=i+1;j<n;j++){
				if(in[j]>in[i]){
					next=in[j];
					break;
				}
			}
			System.out.println(in[i] +" :: " +next); 
		}	
	}
	

	public static void main(String[] args){
		Array a= new Array();
		int[] arr=a.createArray(7);
		//int[] arr={5, 4, 3, 2, 1};
		a.printArray(arr);
		getNextGreaterV1(arr);
	}
}