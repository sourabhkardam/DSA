package com.java.dsa.top100questions.strings;

public class MaxConsecutiveCharacters {

	public static char find(String input) {
		int maxCharCount = 1;
		char maxChar = input.charAt(0);
		int currentCharCount = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				currentCharCount++;
			} else {
				currentCharCount = 1;
			}
			if (currentCharCount > maxCharCount) {
				maxCharCount = currentCharCount;
				maxChar = input.charAt(i);
			}
		}
		return maxChar;
	}

	public static void main(String[] args) {
		System.out.println(find("aaabbbccddddee"));
		System.out.println(find("aabbcc"));
		System.out.println(find("abcdef"));
		System.out.println(find("aabbzzzzaabbb"));
	}

}
