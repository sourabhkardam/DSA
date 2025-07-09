package com.java.dsa.recursion;

public class StringPermutation {

	public static void findPermutation1(StringBuilder inputStr, int leftIndex, int rightIndex) {
		if (leftIndex == rightIndex) {
			System.out.print(inputStr + " ");
			return;
		}
		for (int i = leftIndex; i <= rightIndex; i++) {
			StringBuilder temp = inputStr;
			swap(temp, leftIndex, i);
			findPermutation(inputStr, leftIndex + 1, rightIndex);
		}
	}

	/**
	 * Execution will start on original string first. let's suppose string is "abc".
	 * Now char at leftIndex will be swap with each char next to it including char
	 * at leftIndex itself. As initially lefIndex = 0, rightIndex = 2 so 'a' will be
	 * replace with 'a', then 'a' will be replaced with 'b' and then 'a' will
	 * replaced with 'c'. So string after each iteration will be "abc", "bac", "cba".
	 * If you notice after each swap we are doing recursive call on each of these
	 * strings i.e. method will be called recursively for "abc", "bac", "cba". For
	 * these strings leftIndex = leftIndex + 1 i.e. leftIndex = 1. So, now again
	 * char at leftIndex will be swap with each char next to it including char at
	 * leftIndex itself and so on. And finally when leftIndex == rightIndex will
	 * print the string.
	 */
	public static void findPermutation(StringBuilder inputStr, int leftIndex, int rightIndex) {
		if (leftIndex == rightIndex) {
			System.out.print(inputStr + " ");
			return;
		}
		for (int i = leftIndex; i <= rightIndex; i++) {
			// doing the swap
			swap(inputStr, leftIndex, i);

			findPermutation(inputStr, leftIndex + 1, rightIndex);

			// undoing the swap & bringing inputStr back to original string
			swap(inputStr, leftIndex, i);
		}
	}

	private static void swap(StringBuilder inputStr, int leftIndex, int i) {
		char tempChar = inputStr.charAt(leftIndex);
		inputStr.setCharAt(leftIndex, inputStr.charAt(i));
		inputStr.setCharAt(i, tempChar);
	}

	// Time-Complexity = O(n!)
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abcd";
		System.out.println("All permutation of " + str1 + ": ");
		findPermutation(new StringBuilder(str1), 0, str1.length() - 1);

		System.out.println();
		System.out.println();

		System.out.println("All permutation of " + str2 + ": ");
		findPermutation(new StringBuilder(str2), 0, str2.length() - 1);
	}

}
