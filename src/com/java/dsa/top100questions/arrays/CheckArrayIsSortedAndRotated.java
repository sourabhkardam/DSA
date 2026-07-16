package com.java.dsa.top100questions.arrays;

public class CheckArrayIsSortedAndRotated {

	// Reference solution: https://www.youtube.com/watch?v=Vzs_vlCIFEw
	public static boolean check(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return true;
		}

		int count = 1;

		// Concat the array to itself for e.g. arr = { 4, 5, 1, 2, 3 } then concat of
		// arr = { 4, 5, 1, 2, 3, 4, 5, 1, 2, 3 }. Maintain a sliding window to check if
		// it has a sorted array of size N, if yes then answer is yes else move the
		// window.

		// How to check whether an array is sorted? If an array is sorted then for each
		// index it's previous element will be smaller to it.

		// Note: We are not storing the concat array because then O(n) extra space
		// will be needed instead we are using modulo operator. For e.g. Here we have an
		// arr of size 5 and if we want to fetch the element at 6th index from
		// Concatenated array then it will be index/size i.e. 6/5 = 1. So arr[6] will be
		// same as arr[1] and similary, arr[7] = arr[2] and arr[8] = arr[3] and so on...
		for (int i = 1; i < n * 2; i++) {
			if (nums[(i - 1) % n] <= nums[i % n]) {
				count++;
			} else {
				count = 1;
			}

			if (count == n) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(check(new int[] { 1, 3, 2 }));
		System.out.println(check(new int[] { 4, 5, 1, 2, 3 }));
		System.out.println(check(new int[] { 4, 1, 1, 2, 3 }));
	}
}
