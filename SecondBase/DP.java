package SecondBase;

import java.io.*;

public class DP{
	
	static long Fib(int n){
		long[] F= new long[n+1];
		F[1]=1;
		if(n>1) F[2]=1;
		for (int i=3;i<=n;i++){
			F[i]=F[i-1]+F[i-2];
		}
		return F[n];
	}

	static int longestIncSubseq(int[] arr){
		int n = arr.length;
		int[] Lis = new int[n];
		int res=0;
		for(int i=0;i<n;i++)
			Lis[i]=1;

		Lis[0]=1;
		for(int i=0;i<n;i++){
			for(int j=0	;j<i;j++){
				if(arr[i]>arr[j]){
					Lis[i]= Math.max(Lis[i],1+Lis[j]);
				}
			}
			if(Lis[i]>res) res=Lis[i];
		}
		return res;
	}


	// static int longestContSubseqProdLessK(int[] arr){
	// 	int n = arr.length;
	// 	int[] Res= new int[n];
	// 	for(int i=0;i<n;i++){
	// 		Res[i]=0;
	// 		for(int j=0;j<i;j++)


	// 	}
			
	static int longestComSubseq(char[] s1, char[] s2){
		int m=s1.length;
		int n=s2.length;
		int[][] L= new int[m+1][n+1];

		for(int i=0;i<=m;i++){
			for (int j=0;j<=n;j++){
				if(i==0 || j==0)
					L[i][j]=0;
				else if(s1[i-1]==s2[j-1])
					L[i][j]=1+L[i-1][j-1];
				else
					L[i][j]=Math.max(L[i-1][j],L[i][j-1]);
			}
		}
		return L[m][n];
	}





	public static void main(String[] args){
		int[] arr={10, 22, 90, 33, 21, 50, 41, 60 };
		//int[] arr={10, 9, 2, 5, 3, 7, 101, 18};
		// System.out.println("LIS: " + longestIncSubseq(arr));
		// String s1 = "AGGTAB";
	 //    String s2 = "GXTXAYB";
	 
	 //    char[] X=s1.toCharArray();
	 //    char[] Y=s2.toCharArray();
	 //    System.out.println("LCS: " + longestComSubseq(X,Y));
	    for(int i=1;i<=93;i++)
	    	System.out.println("FIB "+i+": " + Fib(i));
	}
}
