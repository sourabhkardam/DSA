package com.java.dsa.recursion;

/**
 * Find minimum coins used to form an amount
 */
public class MinCoins {
	public static void main(String[] args) {
		int coins[] = { 1, 3, 7 };
		int amount = 50;
		long currentTime = System.currentTimeMillis();
		System.out.println("Minimum coins to build " + amount + " rupees is " + minCoins(coins, amount) + " coins");
		System.out.println("Total time taken is " + (System.currentTimeMillis() - currentTime) / 1000 + " seconds.");
	}

	private static int minCoins(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}

		if (amount < 0) {
			return -1;
		}

		int minCoins = Integer.MAX_VALUE;
		for (int coin : coins) {
			// Dividing problem into sub-problem
			int subResult = minCoins(coins, amount - coin);

			// Adding sub-problem result to current result i.e. subResult =
			// subProblem-result & current-result = 1
			if (subResult >= 0 && subResult + 1 < minCoins) {
				minCoins = subResult + 1;
			}
		}

//		System.out.println("Minimum coins to build " + amount + " rupees is " + minCoins + " coins");

		// if minCoins == Integer.MAX_VALUE, it means not minimum coins found so return
		// -1
		return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
	}
}
