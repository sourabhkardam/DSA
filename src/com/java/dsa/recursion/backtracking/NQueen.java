package com.java.dsa.recursion.backtracking;

import java.util.Arrays;

/**
 * The NQueen class provides a framework to solve the N-Queens problem using
 * recursion and backtracking. The N-Queens problem is to place N queens on an N
 * x N chess-board so that no two queens threaten each other.
 */
public class NQueen {

	public static boolean placeQueens(int[][] chessboard, int currentRowIndex) {
		// If this condition is true, it means we are crossed last row of chess-board
		if (currentRowIndex == chessboard.length) {
			return true;
		}

		for (int col = 0; col < chessboard.length; col++) {
			if (isPositionSafe(chessboard, currentRowIndex, col)) {
				chessboard[currentRowIndex][col] = 1;
				if (placeQueens(chessboard, currentRowIndex + 1)) {
					return true;
				}
				chessboard[currentRowIndex][col] = 0;
			}
		}
		return false;
	}

	private static boolean isPositionSafe(int[][] chessboard, int rowIndex, int colIndex) {
		// we don't need to check whether row is safe or not, because row will be always
		// empty when checking position is safe or not.
		// checking if the column is safe.
		for (int i = 0; i < rowIndex; i++) {
			if (chessboard[i][colIndex] == 1) {
				return false;
			}
		}

		for (int row = rowIndex - 1, col = colIndex - 1; row >= 0 && col >= 0; row--, col--) {
			if (chessboard[row][col] == 1) {
				return false;
			}
		}

		for (int row = rowIndex - 1, col = colIndex + 1; row >= 0 && col < chessboard.length; row--, col++) {
			if (chessboard[row][col] == 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			int[][] chessboard = new int[i][i];
			System.out.println(
					"Placing queens in " + i + " X " + i + " chessboard is possible:" + placeQueens(chessboard, 0));

			Arrays.stream(chessboard).forEach(row -> {
				Arrays.stream(row).forEach(element -> System.out.print(element + ", "));
				System.out.println();
			});

			System.out.println("=====================================================================");
		}
	}

}
