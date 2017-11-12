package SecondBase;

import java.io.*;
import java.util.*;

public class Array{
	
	public int[] createArray(int size){
		int[] res= new int[size];
		Random r = new Random(size);
		int j=0;
		for(int i : r.intList){
			res[j]=i;
			j++;
		}
		return res;
	}

	public void printArray(int[] input){
		for (int i=0; i<input.length; i++){
			System.out.print(input[i] +" ");
		}
		System.out.println();
	}


/*	public class Solution{

	public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int res=0; 
        for(int i=0;i<n;i++){
            int prod=1;int count=0;
            for(int j=i;j<n;j++){
                prod*=nums[j];
                if(prod<k) count++;
                else break;
            }
            System.out.println(i+" "+count);
            res+=count;
        }
        return res;
    }
    	
	int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int[][] res=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                res[i][j]=0;
        }
    
        int count=0;        
        for(int i=1;i<=nums.length;i++){
            count+=prodLength(nums,k,i,res);
        }
        return count;
    }
    
    public int prodLength(int[] nums, int k , int len, int[][] res){
     int start=0;
        int end=len+start-1;
        int count=0;
        while(end<nums.length){
            
            for(int i=0;i<len;i++){
                int prod;
                if(end==0){
                    int prod=nums[i];
                    if(prod<k) res[0][i]=1;
                    else{
                        res[0][i]=0;
                        break;
                    }
                }
                else if(end!=0 && res[start][end-1]==0){
                    res[start][end]=0;
                    break;
                }
                
                else if(end!=0 && res[start][end-1]==1){
                    prod=1;
                    prod=prod*nums[start+i];
                    if(prod>k){
                        res[start][end]=0;
                        break;
                    }
                }
                
            }
            if(prod<k){
                res[start][end]=1;
              //System.out.println(prod);
                count++;  
            } 
            else  res[start][end]=0;
            start++;end++;
        }
        System.out.println(len + ": "+ count);
        System.out.println();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
            
        return count;
    }
}*/


}

