package com.java.dsa.top100questions.arrays;

/**
 * Input: arr[] = [2, 3, -8, 7, -1, 2, 3] Output: 11 Explanation: The subarray
 * [7, -1, 2, 3] has the largest sum 11.
 * 
 * Input: arr[] = [-2, -4] Output: -2 Explanation: The subarray [-2] has the
 * largest sum -2.
 * 
 * Input: arr[] = [5, 4, 1, 7, 8] Output: 25 Explanation: The subarray [5, 4, 1,
 * 7, 8] has the largest sum 25.
 */

public class MaxSubArray {

	public static void main(String[] args) {
		int[] arr = { 2, 3, -8, 7, -1, 2, 3 };
		System.out.println(maxSubarraySum(arr));
	}

	private static int maxSubarraySum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];
			maxSum = Math.max(maxSum, currentSum);

			if (currentSum < 0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}

}
