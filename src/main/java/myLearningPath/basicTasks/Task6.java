package myLearningPath.basicTasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task6 {

	// Stwórz aplikację, która będzie pozwalała użytkownikowi na dodawanie, usuwanie oraz wyświetlanie imion z listy.
	// W przypadku, gdy imię do usunięcia będzie obecne na liście wielokrotnie, usuń wszystkie wystąpienia.
	// Aplikacja powinna działać do momentu, gdy użytkownik nie wybierze opcji kończącej działanie aplikacji.

	public static void main(String[] args) {

		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("Adam");
		nameList.add("Mariusz");
		nameList.add("Kamila");
		nameList.add("Monika");
		nameList.add("Agata");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Wybierz opcję: ");
			System.out.println("1 Dodaj imię");
			System.out.println("2 Usuń imię");
			System.out.println("3 Wyświetl imiona z listy");
			System.out.println("4 Zakończ");

			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1 -> {
					System.out.print("Wpisz imię do dodania: ");
					String newName = scanner.nextLine();
					nameList.add(newName);
					System.out.println("Dodano do listy imię: " + newName);
					System.out.println();
				}

				case 2 -> {
					System.out.print("Wpisz imię do usunięcia: ");
					String nameToDelete = scanner.nextLine();

					if (nameList.contains(nameToDelete)) {
						nameList.removeAll(Collections.singleton(nameToDelete));
						System.out.println("Usunięto z listy: " + nameToDelete);
					} else {
						System.out.println("Brak: " + nameToDelete + " na liście.");
					}
					System.out.println();
				}

				case 3 -> {
					System.out.println("Lista imion: ");

					if (nameList.isEmpty()) {
						System.out.println("Lista jest pusta.");
					} else {
						for (String name : nameList) {
							System.out.println(name);
						}
						System.out.println();
					}
				}

				case 4 -> {
					System.out.println("Koniec");
					return;
				}

				default -> System.out.println("Nieprawidłowy wybór.");
			}
		}
	}
}
