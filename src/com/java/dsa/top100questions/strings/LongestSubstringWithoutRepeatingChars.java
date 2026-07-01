package com.java.dsa.top100questions.strings;

/**
 * Input: s = "geeksforgeeks" Output: 7 Explanation: The longest substrings
 * without repeating characters are "eksforg” and "ksforge", with lengths of 7.
 * 
 * Input: s = "aaa" Output: 1 Explanation: The longest substring without
 * repeating characters is "a"
 * 
 * Input: s = "abcdefabcbb" Output: 6 Explanation: The longest substring without
 * repeating characters is "abcdef".
 */
public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(longestUniqueSubstr(s));
	}

	private static int longestUniqueSubstr(String s) {
		int currentPointer = 0, j = 0;
		int maxLength = 0;
		s = s.toLowerCase();
		boolean[] isVisited = new boolean[256];

		while (currentPointer < s.length()) {
			while (isVisited[s.charAt(currentPointer)]) {
				isVisited[s.charAt(j)] = false;
				j++;
			}

			isVisited[s.charAt(currentPointer)] = true;
			maxLength = Math.max(maxLength, currentPointer - j + 1);

			currentPointer++;
		}

		return maxLength;
	}

}
