package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOptimize {

	public static void main(String[] args) {
		String input = "abc";
		List<String> results = new ArrayList<String>();
		findAllSubSeq(input, 0, "", results);
		results.forEach(result -> {
			if (!result.equals("")) {
				System.out.print(result + ", ");
			}
		});
	}

	private static void findAllSubSeq(String input, int currentIndex, String current, List<String> results) {
		if (currentIndex == input.length()) {
			results.add(current);
			return;
		}

		findAllSubSeq(input, currentIndex + 1, current + input.charAt(currentIndex), results);
		findAllSubSeq(input, currentIndex + 1, current, results);
	}

}
