package com.java.dsa.top100questions.arrays;

public class SecondLargestElement {

	public static void main(String[] args) {
		int[] arr = { 12, 35, 1, 10, 34, 1 };
		System.out.println(getSecondLargest(arr));
	}

	private static int getSecondLargest(int[] arr) {
		int firstLargest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > firstLargest) {
				secondLargest = firstLargest;
				firstLargest = arr[i];
			} else if (arr[i] > secondLargest && secondLargest != firstLargest) {
				secondLargest = arr[i];
			}
		}

		return secondLargest;
	}
}
