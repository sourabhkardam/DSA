package com.java.dsa.top100questions.arrays;

import java.util.HashMap;

public class TwoSum {

	public static int[] findTwoSum(int[] input, int target) {
		int[] twoSum = new int[2];
		HashMap<Integer, Integer> valueWithIndexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			int remaining = target - input[i];
			if (valueWithIndexMap.containsKey(remaining)) {
				twoSum[0] = input[i];
				twoSum[1] = remaining;
			}
			valueWithIndexMap.put(input[i], i);
		}

		return twoSum;
	}

	public static void main(String[] args) {
		int[] arr = { 0, -1, 2, -3, 1 };
		int target = -2;

		int[] result = findTwoSum(arr, target);
		System.out.println(result[0] + ", " + result[1]);

	}

}
