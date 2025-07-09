package com.java.dsa.recursion;

/**
 * Given a rod of length n inches (n = size of price array) and an array
 * price[]. price[i] denotes the value of a piece of length i. The task is to
 * determine the maximum value obtainable by cutting up the rod and selling the
 * pieces. (Reference:
 * https://www.geeksforgeeks.org/dsa/tabulation-vs-memoization/)
 */
public class RodCutting {

	public static void main(String[] args) {

		System.out.println("=====Big Inputs======");
		int[][] inputs = { { 1, 5, 8, 9, 10, 17, 17, 20 }, { 3, 5, 8, 9, 10, 17, 17, 20 }, { 3 } };
		for (int[] input : inputs) {
			System.out.println(findMaxProfit(input, input.length));
		}

		System.out.println("=====Small Inputs======");
		int input[] = { 1, 5 };

		System.out.println(findMaxProfit(input, input.length));

	}

	private static int findMaxProfit(int[] prices, int rodLength) {
		if (rodLength == 0) {
			return 0;
		}

		int maxProfit = 0;

		for (int i = 1; i <= rodLength; i++) {
			// Dividing problem into sub-problem
			int subResult = findMaxProfit(prices, rodLength - i);

			// Adding sub-problem result to current result i.e. subResult =
			// subProblem-result & current-result = prices[i - 1]
			maxProfit = Math.max(maxProfit, subResult + prices[i - 1]);
		}

		return maxProfit;
	}
}
