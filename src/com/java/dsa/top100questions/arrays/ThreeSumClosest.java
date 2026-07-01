package com.java.dsa.top100questions.arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public static int find3SumClosest(int[] input, int target) {
		// Sort the array first
		Arrays.sort(input);

		int closestNum = Integer.MAX_VALUE;
		int closestNumDiff = Integer.MAX_VALUE;

		for (int first = 0; first < input.length - 2; first++) {
			int second = first + 1;
			int third = input.length - 1;
			while (second < third) {
				int sum = input[first] + input[second] + input[third];
				if (target == sum) {
					return sum;
				} else if (sum < target) {
					second++;
				} else {
					third--;
				}

				int currentDiff = Math.abs(target - sum);
				if (currentDiff < closestNumDiff) {
					closestNum = sum;
					closestNumDiff = currentDiff;
				}
			}
		}

		return closestNum;
	}

	public static void main(String[] args) {
		int[] input1 = { -1, 0, 1, 2, -1, -4 };

		System.out.println(find3SumClosest(input1, 1));

		int[] input2 = { 1, 2, 4, 3, 6, 7 };
		System.out.println(find3SumClosest(input2, 5));
	}

}
