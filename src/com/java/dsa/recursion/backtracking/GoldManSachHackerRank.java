package com.java.dsa.recursion.backtracking;

import java.io.*;
import java.util.*;

public class GoldManSachHackerRank {

	public static int smallestValid = -1;

	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		// System.out.println(pattern);
		if (pattern == null || pattern.length() == 0) {
			return smallestValid;
		}
		for (char c : pattern.toCharArray()) {
			if (c != 'M' && c != 'N') {
				return smallestValid;
			}
		}

		boolean[] isVisited = new boolean[10];
		searchPattern(pattern, "", isVisited);
		return smallestValid;
	}

	private static void searchPattern(String pattern, String output, boolean[] isVisited) {
		if (smallestValid != -1) {
			return;
		}
		
		System.out.println("Current output:" + output);

		if (output.length() == pattern.length() + 1) {
			if (followsMNPattern(output, pattern)) {
				smallestValid = Integer.parseInt(output);
			}
			return;
		}

		for (int digit = 1; digit <= 9; digit++) {
			if (!isVisited[digit]) {
				isVisited[digit] = true;
				searchPattern(pattern, output + digit, isVisited);
				isVisited[digit] = false;
			}
		}
	}

	private static boolean followsMNPattern(String digits, String pattern) {
		for (int i = 0; i < pattern.length(); i++) {
			int first = digits.charAt(i) - '0';
			int second = digits.charAt(i + 1) - '0';

			if (pattern.charAt(i) == 'M' && first <= second) {
				return false;
			}

			if (pattern.charAt(i) == 'N' && first >= second) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			bw = new BufferedWriter(new FileWriter(fileName));
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		int res;
		String pattern;
		try {
			pattern = in.nextLine();
		} catch (Exception e) {
			pattern = null;
		}

		res = findPossibleSmallestNumberMatchingPattern(pattern);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();
		in.close();
	}
}
