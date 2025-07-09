package com.java.dsa.recursion;

public class MatrixPaths {

	public static void main(String[] args) {
		int rows = 3;
		int cols = 3;
		System.out.println(findPaths(rows, cols));
	}

	private static int findPaths(int rows, int cols) {
		if (rows == 1 || cols == 1) {
			return 1;
		}

		return findPaths(rows - 1, cols) + findPaths(rows, cols - 1);
	}

}
