package com.java.dsa.top100questions.arrays;

import java.util.Arrays;

/**
 * Input: arr[] = [10, 3, 5, 6, 2] Output: [180, 600, 360, 300, 900]
 */
public class ProductOfArrayExceptSelf {

	public static void find(int[] input) {
		int[] prefix = new int[input.length];
		int[] suffix = new int[input.length];
		// find prefix multiplication with excluding current index
		prefix[0] = 1;
		for (int i = 1; i < prefix.length; i++) {
			prefix[i] = prefix[i - 1] * input[i - 1];
		}

		// find sufix multiplication with excluding current index
		suffix[suffix.length - 1] = 1;
		for (int i = suffix.length - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * input[i + 1];
		}

		// find the produce of array except self now
		for (int i = 0; i < input.length; i++) {
			input[i] = prefix[i] * suffix[i];
		}
	}

	public static void main(String[] args) {
		int arr[] = { 10, 3, 5, 6, 2 };
		find(arr);
		Arrays.stream(arr).forEach(System.out::println);

		// here array.aslist will return address instead of list because arr is of type
		// int not Integer and collection works with objects not primitive data type
//		System.out.println(Arrays.asList(arr));
	}
}
