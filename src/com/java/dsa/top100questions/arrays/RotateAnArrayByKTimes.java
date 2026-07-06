package com.java.dsa.top100questions.arrays;

import java.util.Arrays;

public class RotateAnArrayByKTimes {
	public static void main(String[] args) {
		Integer[] input = { 1, 2, 3, 4, 5 }; // o/p: 3, 4, 5, 1, 2
		rotate(input, 3);
		System.out.println(Arrays.asList(input));
	}

	private static void rotate(Integer[] input, int k) {
		// split array into two half where size of first array = n - k and second array
		// = k and reverse both half and at last reverse whole array.
		int n = input.length;
		reverse(input, 0, n - k - 1);
		reverse(input, n - k, n - 1);
		reverse(input, 0, n - 1);
	}

	private static void reverse(Integer[] input, int start, int end) {
		while (start < end) {
			swap(input, start, end);
			start++;
			end--;
		}
	}

	private static void swap(Integer[] input, int start, int end) {
		int temp = input[start];
		input[start] = input[end];
		input[end] = temp;
	}
}
