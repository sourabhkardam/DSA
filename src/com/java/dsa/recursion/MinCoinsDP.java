package com.java.dsa.recursion;

import java.util.Arrays;

public class MinCoinsDP {
	public static void main(String[] args) {
		int coins[] = { 1, 3, 7 };
		int amount = 50;

		int dp[] = new int[amount + 1];
		Arrays.fill(dp, -1);

		long currentTime = System.currentTimeMillis();
		System.out.println("Minimum coins to build " + amount + " rupees is " + minCoins(coins, amount, dp) + " coins");
		float time = ((float) (System.currentTimeMillis() - currentTime)) / 1000;

		System.out.println("Total time taken is " + time + " seconds.");

		for (int i = 0; i < dp.length; i++) {
			System.out.print("dp[" + i + "] = " + dp[i] + ", ");
		}
	}

	private static int minCoins(int[] coins, int amount, int[] dp) {
		if (amount == 0) {
			return 0;
		}

		int minCoins = Integer.MAX_VALUE;
		for (int coin : coins) {
			int subResult = -1;
			int updatedAmount = amount - coin;

			if (updatedAmount >= 0) {
				if (dp[updatedAmount] != -1) {
					subResult = dp[updatedAmount];
				} else {
					subResult = minCoins(coins, updatedAmount, dp);
				}
			}

			if (subResult >= 0 && subResult + 1 < minCoins) {
				minCoins = subResult + 1;
			}

		}

//		System.out.println("Minimum coins to build " + amount + " rupees is " + minCoins + " coins");
		dp[amount] = minCoins;

		// if minCoins == Integer.MAX_VALUE, it means not minimum coins found so return
		// -1
		return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
	}
}
