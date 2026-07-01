package com.java.dsa.top100questions.arrays;

public class BestTimeToBuyAndSell {
	public static int findMaxProfit(int[] input) {
		int maxProfit = 0;
		int currentMin = input[0];
		for (int i = 1; i < input.length; i++) {
			currentMin = Math.min(currentMin, input[i]);
			maxProfit = Math.max(maxProfit, input[i] - currentMin);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
//		int[] prices = { 7, 10, 1, 3, 6, 9, 2 };
//		int[] prices = { 7, 6, 4, 3, 1 };
		int[] prices = { 1, 3, 6, 9, 11 };
		System.out.println(findMaxProfit(prices));
	}

}
