package com.java.dsa.recursion;

import java.util.Arrays;

public class BasicProblemsWithDP {
	static int count = 0;

	public static void main(String[] args) {
		int n = 15; // Example input
		System.out.println("Factorial of " + n + " is: " + factorial(n));
		System.out.println(n + "th no. in fibonacci series is: " + fibonacci(n) + ", Total Iterations: " + count);

		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		count = 0;
		System.out.println(n + "th no. in fibonacci series is: " + fibonacciDP(n, dp) + ", Total Iterations: " + count);
		System.out.println("Power of n: " + power(n, 3));
	}

	private static int fibonacciDP(int n, int[] dp) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		if (dp[n] != -1) {
			return dp[n];
		} else {
			dp[n] = fibonacciDP(n - 1, dp) + fibonacciDP(n - 2, dp);
		}

		count++;

		return dp[n];
	}

	private static int power(int n, int a) {
		if (a == 0) {
			return 1;
		}
		return n * power(n, a - 1);
	}

	private static int fibonacci(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		count++;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
