package myLearningPath.basicTasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {

	//Stwórz ArrayListę i dodaj do niej dziesięć imion. Pozwól użytkownikowi zapytać o wybrane imię.
	// Jeżeli zostanie znalezione, wyświetl użytkownikowi indeks lub indeksy, pod którym / którymi znajduje się dane imię.
	// Jeżeli imię nie zostanie znalezione, również wyświetl odpowiednią informację.

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<>();
		names.add("Barbara");
		names.add("Mariusz");
		names.add("Michał");
		names.add("Agata");
		names.add("Monika");
		names.add("Jan");
		names.add("Agnieszka");
		names.add("Bonifacy");
		names.add("Maurycy");
		names.add("Mikołaj");

		Scanner scanner = new Scanner(System.in);

		System.out.print("Podaj imię, którego szukasz: ");
		String imieDoWyszukania = scanner.nextLine();

		ArrayList<Integer> indeksy = new ArrayList<>();


		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).equalsIgnoreCase(imieDoWyszukania)) {
				indeksy.add(i);
			}
		}

		if (indeksy.isEmpty()) {
			System.out.println("Brak danych");
		} else {
			for (int indeks : indeksy) {
				System.out.println("Imię znajduje się pod indeksem: " + indeks);
			}
		}
	}
}
