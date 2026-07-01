package com.java.dsa.top100questions.arrays;

import java.util.Stack;

/**
 * Input: arr[] = [1, 3, 2, 4] Output: [3, 4, 4, -1] Explanation: The next
 * larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist,
 * it is -1.
 * 
 * Input: arr[] = [6, 8, 0, 1, 3] Output: [8, -1, 1, 3, -1] Explanation: The
 * next larger element to 6 is 8, for 8 there is no larger elements hence it is
 * -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element
 * on right and hence -1.
 */
// A monotanic stack problem
public class NextGreaterElement {

	private static int[] nextLargerElement(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && arr[i] > stack.peek()) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}

			stack.push(arr[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 8, 0, 1, 3 };
		int[] res = nextLargerElement(arr);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}

}
