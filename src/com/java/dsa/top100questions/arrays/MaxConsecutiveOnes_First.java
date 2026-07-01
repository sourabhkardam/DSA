package com.java.dsa.top100questions.arrays;

// Sliding Window
public class MaxConsecutiveOnes_First {
	public static int findMaxConsecutiveOnes(int[] nums) {
		int first = 0, second = 0;
		int maxOnes = 0;
		while (second < nums.length) {
			if (nums[second] == 0) {
				first = second + 1;
			}
			maxOnes = Math.max(maxOnes, second - first + 1);
			second++;
		}
		return maxOnes;
	}

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
	}
}
