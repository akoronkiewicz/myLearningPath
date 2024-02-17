package myLearningPath.basicTasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {


	//Poproś użytkownika o wpisanie dowolnego zdania,
	// a następnie wykorzystując HashMapę policz liczbę wystąpień każdej litery w zdaniu.

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Wprowadź dowolne zdanie: ");
		String zdanie = scanner.nextLine();

		zdanie = zdanie.replaceAll(" ", "").toLowerCase();

		HashMap<Character, Integer> zliczenia = new HashMap<>();

		for (char litera : zdanie.toCharArray()) {
			if (Character.isLetter(litera)) {
				if (zliczenia.containsKey(litera)) {
					zliczenia.put(litera, zliczenia.get(litera) + 1);
				} else {
					zliczenia.put(litera, 1);
				}
			}
		}

		System.out.println("Zliczenia liter w zdaniu:");
		for (Map.Entry<Character, Integer> entry : zliczenia.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
