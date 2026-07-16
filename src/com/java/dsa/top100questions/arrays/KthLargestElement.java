package com.java.dsa.top100questions.arrays;

import java.util.PriorityQueue;

/**
 * Input: [1, 23, 12, 9, 30, 2, 50], K = 3 Output: 23
 * 
 * Input: [12, 3, 5, 7, 19], K = 2 Output: 12
 */
public class KthLargestElement {

	public static void main(String[] args) {
		int[] input1 = { 1, 23, 12, 9, 30, 2, 50 };
		System.out.println(find(input1, 3));

		int[] input2 = { 12, 3, 5, 7, 19 };
		System.out.println(find(input2, 2));
	}

	private static int find(int[] input, int k) {
		if (k > input.length) {
			return -1;
		}

		// If we have to find largest element, maintain a min-heap and if we have to
		// find smallest maintain max-heap.
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		for (int ele : input) {
			priorityQueue.add(ele);

			// Here we are maintaining a min-heap of size k that means if any element is
			// added to this heap than heap will re-heapify and root element will be the
			// smallest one.
			// So, if heap size is k and newly added element is a minimum
			// element from all the elements of heap than it will be on top of heap and then
			// it will be removed using poll method.
			// But if newly added element is not minimum from all the elements of heap than
			// the minimum element among current heap will sit on top once we add this
			// element to heap because heap will re-heapify.

			// It mean every time an element is added to heap of size k, heap will make sure
			// min element sits on top and we can remove it. This way heap of size k will
			// have k-largest elements on every add operation.
			if (priorityQueue.size() > k) {
				priorityQueue.poll();
			}
		}

		return priorityQueue.peek();
	}

}
