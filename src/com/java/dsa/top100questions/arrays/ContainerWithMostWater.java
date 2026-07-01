package com.java.dsa.top100questions.arrays;

public class ContainerWithMostWater {

	public static int getResult(int[] input) {
		int max = 0;
		int start = 0, end = input.length - 1;

		while (start < end) {
			if (input[start] < input[end]) {
				max = Math.max(max, input[start] * (end - start));
				start++;
			} else {
				max = Math.max(max, input[end] * (end - start));
				end--;
			}
		}

		return max;
	}

	public static void main(String[] args) {
//		int[] arr = { 2, 1, 8, 6, 4, 6, 5, 5 };
		int[] arr = { 3, 1, 2, 4, 5 };
		System.out.println(getResult(arr));
	}

}
