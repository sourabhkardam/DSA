package com.java.dsa.top100questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static List<List<Integer>> find3Sum(int[] input, int target) {
		// Sort the array first
		Arrays.sort(input);

		Set<List<Integer>> result = new HashSet<List<Integer>>();
		for (int first = 0; first < input.length - 2; first++) {
			int second = first + 1;
			int third = input.length - 1;
			while (second < third) {
				int sum = input[first] + input[second] + input[third];
				if (target == sum) {
					result.add(Arrays.asList(input[first], input[second], input[third]));
					second++;
					third--;
				} else if (sum < target) {
					second++;
				} else {
					third--;
				}
			}
		}

		return new ArrayList<List<Integer>>(result);
	}

	public static void main(String[] args) {
		int[] input1 = { -1, 0, 1, 2, -1, -4 }; // Output: [[-1,-1,2],[-1,0,1]] with target == 0

		System.out.println(find3Sum(input1, 0));

		int[] input2 = { 1, 2, 4, 3, 6, 7 }; // Output: [1, 3, 6] and [1, 2, 7] with target == 10
		System.out.println(find3Sum(input2, 10));
	}

}
