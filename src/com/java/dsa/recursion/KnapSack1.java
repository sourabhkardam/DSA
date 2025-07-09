package com.java.dsa.recursion;

/**
 * As weights can be used only once, that's why using pure recursion this way is
 * inefficent. O(n) = m^n
 */
public class KnapSack1 {

	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int bagWeighCapacity = 50;
//		int n = weights.length;
		boolean[] isVisited = new boolean[weights.length];
		int maxProfit = knapsack(weights, values, isVisited, bagWeighCapacity);
		System.out.println("Maximum value in Knapsack = " + maxProfit);
	}

	private static int knapsack(int[] weights, int[] values, boolean[] isVisited, int bagWeighCapacity) {
		if (bagWeighCapacity == 0) {
			return 0;
		}

		if (bagWeighCapacity < 0) {
			return -1;
		}

		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < weights.length; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				int subResult = knapsack(weights, values, isVisited, bagWeighCapacity - weights[i]);
				isVisited[i] = false;
				if (subResult >= 0) {
					maxProfit = Math.max(maxProfit, subResult + values[i]);
				}
			}
		}

		return maxProfit == Integer.MIN_VALUE ? -1 : maxProfit;
	}

}
