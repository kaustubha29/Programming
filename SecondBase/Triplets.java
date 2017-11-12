package SecondBase;

import java.io.*;
import java.math.*;

public class Triplets{
	public static int MaxProd(int[] arr){
		int max1,max2,max3;
		int min1,min2;
		max1=max2=max3=Integer.MIN_VALUE;
		min1=min2=Integer.MAX_VALUE;
		if(arr.length<3) return -1;
		for (int num:arr){
			if(num>max1){
				max3=max2;max2=max1;
				max1=num;
			}
			else if(num>max2){
				max3=max2;
				max2=num;
			}
			else if(num>max3) max3=num;
			if(num<min1){
				min2=min1;
				min1=num;
			}
			else if(num<min2) min2=num;
		}
		return Math.max((max1*max2*max3), (max1*min1*min2));
	}

	public static void main(String[] args){
		Array a= new Array();
		//int[] arr=a.createArray(7);
		int[] arr={1, 4, 3, -6, -7, 0};
		a.printArray(arr);
		System.out.println("Max Prod of triplet is : " + MaxProd(arr));
	}
}