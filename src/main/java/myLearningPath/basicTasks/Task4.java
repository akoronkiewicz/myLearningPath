package myLearningPath.basicTasks;

import java.util.HashMap;
import java.util.Scanner;

public class Task4 {

	//Stwórz HashMapę, która będzie przechowywać państwa oraz ich stolice.
	// Dodaj do niej pięć przykładowych elementów.
	// Pozwól użytkownikowi zapytać o państwo i w odpowiedzi wyświetl stolicę tego państwa.
	// Gdy państwo nie będzie obecne w HashMapie, wyświetl użytkownikowi odpowiedni komunikat.
	public static void main(String[] args) {

		HashMap<String, String> countriesAndCapitals = new HashMap<>();
		countriesAndCapitals.put("Polska", "Warszawa");
		countriesAndCapitals.put("Chorwacja", "Zagrzeb");
		countriesAndCapitals.put("Włochy", "Rzym");
		countriesAndCapitals.put("Portugalia", "Lizbona");
		countriesAndCapitals.put("Litwa", "Wilno");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Wpisz nazwę państwa aby wyświetlić jego stolicę: ");
		String country = scanner.nextLine();

		String capital = countriesAndCapitals.get(country);

		if (country != null) {
			System.out.println("Stolica tego kraju to: " + capital);
		} else {
			System.out.println("Nie wiem");
		}
	}
}
