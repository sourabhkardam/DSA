package com.java.dsa.top100questions.strings;

import java.util.Arrays;

public class PrefixString {

	public static void main(String[] args) {
		String[] str = { "hi", "flower", "flow", "flight" };
		System.out.println("Prefix:" + findPrefix(str));
		System.out.println("Prefix using streams:" + findPrefixUsingStream(str));
	}

	private static String findPrefixUsingStream(String[] str) {
		return Arrays.stream(str).reduce((str1, str2) -> {
			if (str1.isEmpty())
				return str1;
			if (str2.isEmpty())
				return str2;

			int i = 0, j = 0;
			while (i < str1.length() && j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			}

			return str1.substring(0, i);
		}).orElseThrow();
	}

	private static String findPrefix(String[] str) {
		if (str.length == 0) {
			return "";
		}

		String currentPrefix = str[0];
		for (int i = 1; i < str.length; i++) {
			String currentStr = str[i];
			int a = 0, b = 0;
			while (a < currentPrefix.length() && b < currentStr.length()
					&& currentPrefix.charAt(a) == currentStr.charAt(b)) {
				a++;
				b++;
			}

			if (a == 0) {
				currentPrefix = "";
				break;
			}

			currentPrefix = currentPrefix.substring(0, a);
		}

		return currentPrefix;
	}

}
