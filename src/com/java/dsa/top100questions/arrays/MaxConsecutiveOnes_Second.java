package com.java.dsa.top100questions.arrays;

/**
 * Input: arr[] = [1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1], k = 2 Output: 8
 * Explanation: By flipping the zeroes at index 5 and 7, we get the longest
 * subarray from index 3 to 10 containing all 1's.
 * 
 * Input: arr[] = [1, 0, 0, 1, 0, 1, 0, 1], k = 2 Output: 5 Explanation: By
 * flipping the zeroes at indices 4 and 6, we get the longest subarray from
 * index 3 to 7 containing all 1's.
 */
public class MaxConsecutiveOnes_Second {

	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1 };
		int k = 2;
		System.out.println(maxOnes(arr, k));
	}

	private static int maxOnes(int[] arr, int k) {
		int count = 0;
		int start = 0, end = 0;
		int result = 0;

		while (end < arr.length) {
			if (arr[end] == 0) {
				count++;
			}

			while (count > k) {
				if (arr[start] == 0) {
					count--;
				}

				start++;
			}

			result = Math.max(result, end - start + 1);

			end++;
		}

		return result;
	}

}
