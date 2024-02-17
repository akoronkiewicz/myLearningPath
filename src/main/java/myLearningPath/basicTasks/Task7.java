package myLearningPath.basicTasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task7 {

	//Stwórz prostą aplikację umożliwiającą wypożyczanie samochodów.
	// Wykorzystaj do tego HashMapę, w której kluczem będzie nazwa samochodu,
	// a wartością informacja czy samochód jest dostępny do wypożyczenia czy nie.
	// Pozwól użytkownikowi na wyświetlanie wszystkich samochodów (wraz z informacją czy są dostępne czy nie),
	// na wyświetlanie tylko dostępnych samochodów oraz wyświetlanie wypożyczonych przez niego samochodów.
	// Nie pozwól, by użytkownik mógł wypożyczyć więcej niż 3 samochody naraz.

	public static void main(String[] args) {

		HashMap<String, Boolean> cars = new HashMap<>();
		cars.put("audi", true);
		cars.put("volvo", true);
		cars.put("mazda", true);
		cars.put("skoda", true);
		cars.put("kia", false);
		cars.put("jeep", true);
		cars.put("toyota", false);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Wybierz opcję: ");
			System.out.println("1 Wyświetl listę samochodów");
			System.out.println("2 Wyświetl dostępne samochody");
			System.out.println("3 Wypożycz samochód");
			System.out.println("4 Wyświetl wypożyczone samochody");
			System.out.println("5 Wyjście");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1 -> {
					System.out.println("Lista samochodów");
					for (Map.Entry<String, Boolean> car : cars.entrySet()) {
						String carToPrint = car.getKey();
						boolean available = car.getValue();
						String isAvailable = available ? " - dostępny" : " - niedostępny";
						System.out.println(carToPrint + isAvailable);
					}
				}
				case 2 -> {
					System.out.println("Dostępne samochody: ");
					for (Map.Entry<String, Boolean> car : cars.entrySet()) {
						if (car.getValue()) {
							System.out.println(car.getKey());
						}
					}
				}
				case 4 -> {
					System.out.println("Wypożyczone samochody");

				}
				case 5 -> {
					return;
				}
				default -> System.out.println("Nieprawidłowy wybór");
			}
		}
	}
}
