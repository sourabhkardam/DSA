package com.java.dsa.recursion;

import java.util.Arrays;

/**
 * Given a rod of length n inches (n = size of price array) and an array
 * price[]. price[i] denotes the value of a piece of length i. The task is to
 * determine the maximum value obtainable by cutting up the rod and selling the
 * pieces. (Reference:
 * https://www.geeksforgeeks.org/dsa/tabulation-vs-memoization/)
 */
public class RodCuttingDP {

	public static void main(String[] args) {

		System.out.println("=====Big Inputs======");
		int[][] inputs = { { 1, 5, 8, 9, 10, 17, 17, 20 }, { 3, 5, 8, 9, 10, 17, 17, 20 }, { 3 } };
		for (int[] input : inputs) {
			int[] dp = new int[input.length + 1];
			Arrays.fill(dp, -1);
			System.out.println("Max Profit: " + findMaxProfit(input, input.length, dp));
			for (int i = 0; i < dp.length; i++) {
				System.out.print("dp[" + i + "] = " + dp[i] + ", ");
			}
			System.out.println();
			System.out.println("---------------------------------------------------");
		}

		System.out.println("=====Small Inputs======");
		int input[] = { 1, 5 };
		int[] dp = new int[input.length + 1];
		Arrays.fill(dp, -1);
		System.out.println("Max Profit: " + findMaxProfit(input, input.length, dp));
		for (int i = 0; i < dp.length; i++) {
			System.out.print("dp[" + i + "] = " + dp[i] + ", ");
		}

	}

	private static int findMaxProfit(int[] prices, int rodLength, int[] dp) {
		if (rodLength == 0) {
			return 0;
		}

		if (dp[rodLength] != -1) {
			return dp[rodLength];
		}

		int maxProfit = 0;

		for (int i = 1; i <= rodLength; i++) {
			int subResult = findMaxProfit(prices, rodLength - i, dp);
			if (subResult >= 0) {
				maxProfit = Math.max(maxProfit, subResult + prices[i - 1]);
			}
		}

		dp[rodLength] = maxProfit;
		return maxProfit;
	}
}
