package com.java.dsa.top100questions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Input: arr[] = [3, 1, 4, 4, 5, 2, 6, 1], k = 2 Output: [4, 1] Explanation:
 * Frequency of 4 is 2 and frequency of 1 is 2, these two have the maximum
 * frequency.
 * 
 * Input: arr[] = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4 Output: [5, 11, 7,
 * 10] Explanation: Frequency of 5 is 3, frequency of 11 is 2, frequency of 7 is
 * 2, and frequency of rest is 1 but 10 is largest .
 */
public class TopKLargestElements {

	public static void main(String[] args) {
		int input1[] = { 3, 1, 4, 4, 5, 2, 6, 1 };
		int input2[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };

		System.out.println(findTopK(input1, 2));
		// As we have only 3 elements whose frequency > 1 so 4th will be that whose
		// frequency is 1 for which we have many candidates. So 4th element can be
		// anyone.
		System.out.println(findTopK(input2, 4));

		System.out.println(findTopKOptimal(input1, 2));
		System.out.println(findTopKOptimal(input2, 4));
	}

	private static List<Integer> findTopKOptimal(int[] input, int k) {
		Map<Integer, Long> freqMap = Arrays.stream(input).mapToObj(x -> Integer.valueOf(x))
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		// Create frequency list which will basically track how many elements frequency
		// is same as ith index. So basically if we are at 2th index then will check
		// those elements whose frequency is 2 and then add the element in list at 2th
		// index.
		ArrayList<ArrayList<Integer>> freqList = new ArrayList<>();
		for (int i = 0; i <= input.length; i++) {
			freqList.add(new ArrayList<>());
		}

		for (Entry<Integer, Long> entry : freqMap.entrySet()) {
			Integer key = entry.getKey();
			Long value = entry.getValue();

			freqList.get(value.intValue()).add(key);
		}

		List<Integer> result = new ArrayList<Integer>();
		for (int i = freqList.size() - 1; i >= 1; i--) {
			if (!freqList.get(i).isEmpty()) {
				for (int j = 0; j < freqList.get(i).size(); j++) {
					result.add(freqList.get(i).get(j));

					if (result.size() == k) {
						return result;
					}
				}

			}

		}

		return result;

	}

	private static List<Integer> findTopK(int[] input, int k) {
		Map<Integer, Long> freqMap = Arrays.stream(input).mapToObj(x -> Integer.valueOf(x))
				.collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		PriorityQueue<Entry<Integer, Long>> pq = new PriorityQueue<Map.Entry<Integer, Long>>(
				(entry1, entry2) -> Long.compare(entry1.getValue(), entry2.getValue()));

		for (Entry<Integer, Long> entry : freqMap.entrySet()) {
			pq.add(entry);

			if (pq.size() > k) {
				pq.remove();
			}
		}

		List<Integer> result = new ArrayList<Integer>();
		while (!pq.isEmpty()) {
			result.add(pq.remove().getKey());
		}

		return result;

	}

}
