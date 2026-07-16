package com.java.dsa.random;

import java.util.Arrays;

public class FibonacciSeries {

	public static void printFibWithMemory(int n) {
		if (n == 0)
			return;

		if (n == 1) {
			System.out.println(n);
			return;
		}

		int[] fibSeries = new int[n];
		fibSeries[0] = 1;
		fibSeries[1] = 1;

		for (int i = 2; i < n; i++) {
			fibSeries[i] = fibSeries[i - 1] + fibSeries[i - 2];
		}

		Arrays.stream(fibSeries).forEach(e -> System.out.print(e + ","));
		System.out.println();
	}

	public static void printFibWithOutMemory(int n) {
		if (n == 0)
			return;

		int first = 1;
		System.out.print(first);

		int second = 1;
		System.out.print("," + second);

		for (int i = 2; i < n; i++) {
			int next = first + second;
			System.out.print("," + next);

			first = second;
			second = next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		printFibWithMemory(1);
		printFibWithMemory(2);
		printFibWithMemory(5);
		printFibWithMemory(7);

		System.out.println();

		printFibWithOutMemory(1);
		printFibWithOutMemory(2);
		printFibWithOutMemory(5);
		printFibWithOutMemory(7);
	}

}
