package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceBruteForce {
	public static void main(String[] args) {
		String input = "abc";
		char[] charArray = input.toCharArray();
		List<String> subSequences = new ArrayList<String>();
		subSequences.add("");

		for (char c : charArray) {
			int size = subSequences.size();
			for (int i = 0; i < size; i++) {
				subSequences.add(subSequences.get(i) + c);
			}
		}

		subSequences.forEach(result -> {
			if (!result.equals("")) {
				System.out.print(result + ", ");
			}
		});
	}
}
