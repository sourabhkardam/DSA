package com.java.dsa.top100questions.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class GroupAnagram {

	public static void main(String[] args) {
		String[] input = { "act", "god", "cat", "dog", "tac" };

		System.out.println(groupAnagrams(input));

		ArrayList<List<String>> arrayList = groupAnagramsUsingStream(input);

		System.out.println(arrayList);

		System.out.println(groupAnagramsEfficentWay(input));
	}

	// Time Complexity: n x k where n = no. of words and k = max length of a word
	private static ArrayList<List<String>> groupAnagramsEfficentWay(String[] input) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String word : input) {
			int[] wordCharsFreqArray = new int[26];

			// Counting Frequency of each char in a word
			for (char c : word.toCharArray()) {
				wordCharsFreqArray[c - 'a']++;
			}

			// Forming a unique key
			StringBuilder key = new StringBuilder();
			for (int count : wordCharsFreqArray) {
				key.append("#").append(count);
			}

			map.computeIfAbsent(key.toString(), e -> new ArrayList<String>()).add(word);
		}
		return new ArrayList<List<String>>(map.values());
	}

	// Time Complexity: n x k log k where n = no. of words and k = max length of a
	// word
	private static ArrayList<List<String>> groupAnagramsUsingStream(String[] input) {
		Map<String, List<String>> map = Arrays.stream(input).collect(Collectors.groupingBy(str -> {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}));
		
		System.out.println(map);
		
		return new ArrayList<>(map.values());
	}

	private static ArrayList<ArrayList<String>> groupAnagrams(String[] arr) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		HashMap<String, ArrayList<String>> keyMap = new HashMap<String, ArrayList<String>>();

		for (String input : arr) {
			char[] charArray = input.toCharArray();
			Arrays.sort(charArray);
			String key = Arrays.toString(charArray);

			if (!keyMap.containsKey(key)) {
				keyMap.put(key, new ArrayList<String>());
			}

			keyMap.get(key).add(input);
		}

		for (Entry<String, ArrayList<String>> entry : keyMap.entrySet()) {
			result.add(entry.getValue());
		}

		return result;
	}

}
