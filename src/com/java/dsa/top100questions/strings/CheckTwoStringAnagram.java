package com.java.dsa.top100questions.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CheckTwoStringAnagram {
	public static void main(String[] args) {
		String s1 = "geeks";
		String s2 = "kseeg";

		System.out.println(areAnagramsUsingSorting(s1, s2));
		System.out.println(areAnagramsUsingMap(s1, s2));
	}

	private static boolean areAnagramsUsingSorting(String s1, String s2) {
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();

		Arrays.sort(s1CharArray);
		Arrays.sort(s2CharArray);

		return Arrays.equals(s1CharArray, s2CharArray);
	}

	private static boolean areAnagramsUsingMap(String s1, String s2) {
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();

		if (s1CharArray.length != s2CharArray.length) {
			return false;
		}

		HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
		for (Character c : s1CharArray) {
			charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
		}

		for (Character c : s2CharArray) {
			charCounts.put(c, charCounts.getOrDefault(c, 0) - 1);
		}

		Set<Entry<Character, Integer>> entrySet = charCounts.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() != 0) {
				return false;
			}
		}

		return true;
	}
}
