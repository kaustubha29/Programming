package SecondBase;
import java.io.*;

public class Stock{
	
	/*
	https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description
	*/
	static int oneMaxProfit(int[] arr){
		int minPrice=Integer.MAX_VALUE;int maxPrice=Integer.MIN_VALUE; int profit=0;
		//minPrice=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]<minPrice) minPrice=arr[i];
			if(arr[i]>maxPrice) maxPrice=arr[i];
			else maxPrice=minPrice; //Max Price only after i
			profit=Math.max(profit, maxPrice-minPrice);
			//System.out.println(i +" "+minPrice+" "+maxPrice+" "+profit);
		}
		return profit;
	}
	
	/*
	https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	*/

	// K transactions but Sell before buying

	static int totalProfit(int[] arr){
		int profit=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>arr[i-1])
				profit+=arr[i]-arr[i-1];
		}
		return profit;
	}
	/*
	https://leetcode.com/contest/leetcode-weekly-contest-55/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
	*/
	static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] moneyToBuy = new int[n];
        int[] finalMoney = new int[n];
        moneyToBuy[0]=-prices[0];
        for(int i=1;i<n;i++){
        	//To buy or Not
        	moneyToBuy[i]=Math.max(moneyToBuy[i-1], finalMoney[i-1]-prices[i]);
        	// To sell or not
        	finalMoney[i]=Math.max(finalMoney[i-1], moneyToBuy[i-1]+prices[i]-fee);
        }
        return finalMoney[n-1];
    }

        /*int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            // buy one.
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            // sell one.
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
     		System.out.print(dp[i][0] + " " + dp[i][1]);
     		System.out.println();
        }
        return dp[n-1][0];
    }*/

	public static void main(String args[]){
        //int arr[] = {7,10,15,5,11,2,7,9,3};
        int arr[] = {3,3,5,0,0,3,1,4};
        //int[] arr = {7, 6, 4, 3, 1};
        //int arr1[] = {6,4,1,3,5,7,3,1,3,4,7,9,2,5,6,0,1,2};
       
        //System.out.println(oneMaxProfit(arr));
        //System.out.println(totalProfit(arr));
        System.out.println(maxProfit(arr,2));
    }
       
}