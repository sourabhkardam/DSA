package com.java.dsa.top100questions.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of length n, divide it into chunks so that each chunk is of
 * size k. Last chunk length can be <= k
 */
public class BreakTextIntoChunks {
	public static void main(String[] args) {
		String input = """
				My name is Sourabh. I currently worked as Senior software engineer.
				""";
		int chunkSize = 4;
		List<String> chunks = getChunks(input, chunkSize);
		System.out.println(chunks);
	}

	private static List<String> getChunks(String input, int chunkSize) {
		List<String> chunks = new ArrayList<String>();
		for (int i = 0; i < input.length(); i = i + chunkSize) {
			chunks.add(input.substring(i, Math.min(i + chunkSize, input.length())));
		}
		return chunks;
	}
}
