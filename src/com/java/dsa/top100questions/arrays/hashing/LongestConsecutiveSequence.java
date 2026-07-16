package com.java.dsa.top100questions.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
		Set<Integer> lookUpSet = new HashSet<Integer>();
		for (int ele : nums) {
			lookUpSet.add(ele);
		}

		int longest = 0;
		for (int ele : nums) {
			// If current element not start of a sequence, skip it.
			if (lookUpSet.contains(ele - 1))
				continue;

			int length = 1;

			// Increase the counter till it has a next element present
			while (lookUpSet.contains(ele + length)) {
				length++;
			}

			longest = Math.max(longest, length);
		}

		return longest;
	}

	public static void main(String[] args) {
		int[] nums1 = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums1)); // The longest consecutive elements sequence is [1, 2, 3, 4].
														// Therefore its length is 4.

		int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(nums2));
	}

}
