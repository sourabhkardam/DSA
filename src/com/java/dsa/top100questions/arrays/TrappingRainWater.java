package com.java.dsa.top100questions.arrays;

public class TrappingRainWater {

	public static int findUsingPrefixAndSuffixMax(int[] input) {
		int total = 0;
		int[] suffixMax = new int[input.length];

		suffixMax[input.length - 1] = input[input.length - 1];
		for (int i = suffixMax.length - 2; i >= 0; i--) {
			suffixMax[i] = Math.max(input[i], suffixMax[i + 1]);
		}

		int prefixMax = input[0];
		for (int i = 1; i < input.length; i++) {
			// Maintaining prefixMax for each index
			prefixMax = Math.max(prefixMax, input[i]);

			// finding water on particular building (index) and adding it to total sum
			total += Math.min(prefixMax, suffixMax[i]) - input[i];
		}

		return total;
	}

	public static int findUsingTwoPointers(int[] input) {
		int total = 0;
		int leftMax = 0, rightMax = 0;

		int leftPointer = 0, rightPointer = input.length - 1;

		while (leftPointer < rightPointer) {
			leftMax = Math.max(leftMax, input[leftPointer]);
			rightMax = Math.max(rightMax, input[rightPointer]);

			if (leftMax < rightMax) {
				total += leftMax - input[leftPointer];
				leftPointer++;
			} else {
				total += rightMax - input[rightPointer];
				rightPointer--;
			}
		}

		return total;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 0, 1, 0, 4, 0, 2 };
//		int arr[] = { 3, 0, 2, 0, 4 };

		System.out.println(findUsingPrefixAndSuffixMax(arr));
		System.out.println(findUsingTwoPointers(arr));
	}

}
