package com.java.dsa.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JosephusProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter number of persons");
		int n = sc.nextInt();

		System.out.println("Please enter value of k");
		int k = sc.nextInt();

		List<Integer> persons = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			persons.add(i + 1);
		}

		k--;

		System.out.println("Recursive solution");
		solveRecursively(persons, 0, k);

		System.out.println();
		
		System.out.println("Iterative solution");
		solveIteratively(persons, 0, k);

		sc.close();

	}

	private static void solveRecursively(List<Integer> persons, int currentIndex, int k) {
		if (persons.size() == 1) {
			System.out.println("Person " + persons.get(0) + " is saved.");
			return;
		}

		int personToBeKilledIndex = (currentIndex + k) % persons.size();

		// As we determined which person needs to be killed, we can remove that person
		// means we are basically shifting the one position backwards for all the
		// persons ahead of killed person.
		persons.remove(personToBeKilledIndex);

		// As all person ahead of killed person is shifted one position backwards it
		// means now the current index is same as personToBeKilledIndex
		solveRecursively(persons, personToBeKilledIndex, k);
	}

	private static void solveIteratively(List<Integer> persons, int currentIndex, int k) {
		while (persons.size() > 1) {
			int personToBeKilledIndex = (currentIndex + k) % persons.size();
			persons.remove(personToBeKilledIndex);
			currentIndex = personToBeKilledIndex;
		}
		System.out.println("Person " + persons.get(0) + " is saved.");
	}
}