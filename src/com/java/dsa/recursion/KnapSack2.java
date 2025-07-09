package com.java.dsa.recursion;

/**
 * As weights can be used only once, that's why using pure recursion this way is
 * efficent. O(n) = 2^n
 */
public class KnapSack2 {

	// Recursive function to solve 0/1 Knapsack
	public static int knapsack(int[] wt, int[] val, int n, int W) {
		// Base case: no items left or capacity is 0
		if (n == 0 || W == 0) {
			return 0;
		}

		// If weight of the nth item is more than the capacity, skip it
		if (wt[n - 1] > W) {
			return knapsack(wt, val, n - 1, W);
		} else {
			// Return the maximum of including or excluding the item
			return Math.max(val[n - 1] + knapsack(wt, val, n - 1, W - wt[n - 1]), knapsack(wt, val, n - 1, W));
		}
	}

	public static void main(String[] args) {
		int[] weights = { 10, 20, 30 };
		int[] values = { 60, 100, 120 };
		int capacity = 50;
		int n = weights.length;

		int maxProfit = knapsack(weights, values, n, capacity);
		System.out.println("Maximum value in Knapsack = " + maxProfit);
	}
}
