package com.java.dsa.top100questions.arrays;

import java.util.ArrayList;

public class InsertAndMergeIntervals {
	public static void main(String[] args) {
//		int[][] intervals = { { 1, 3 }, { 4, 5 }, { 6, 7 }, { 8, 10 } };
//		int[] newInterval = { 5, 6 };
		
		int[][] intervals = {{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {5, 8};

		ArrayList<int[]> res = insertInterval(intervals, newInterval);
		for (int[] interval : res) {
			System.out.println(interval[0] + " " + interval[1]);
		}
	}

	private static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
		int i = 0;
		ArrayList<int[]> result = new ArrayList<int[]>();
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
			newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
			i++;
		}

		result.add(newInterval);

		while (i < intervals.length) {
			result.add(intervals[i]);
			i++;
		}

		return result;
	}
}
