package com.java.dsa.top100questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static List<int[]> merge(int[][] arr) {
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		// Print the sorted array
		Arrays.asList(arr).stream().forEach(subArr -> System.out.print("{" + subArr[0] + "," + subArr[1] + "}, "));
		System.out.println();

		// Initializing result with first element of sorted array
		List<int[]> result = new ArrayList<int[]>();

		result.add(new int[] { arr[0][0], arr[0][1] });

		for (int i = 1; i < arr.length; i++) {
			int[] lastInterval = result.get(result.size() - 1);
			int lastElement = lastInterval[1];

			int[] currentInterval = arr[i];
			int currentElement = currentInterval[0];
			if (currentElement <= lastElement) {
				lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
			} else {
				result.add(new int[] { currentInterval[0], currentInterval[1] });
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[][] arr = { { 7, 8 }, { 1, 5 }, { 2, 4 }, { 4, 6 } };
		List<int[]> result = merge(arr);

		for (int[] interval : result)
			System.out.println(interval[0] + " " + interval[1]);
	}

}
