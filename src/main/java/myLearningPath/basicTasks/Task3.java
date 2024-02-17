package myLearningPath.basicTasks;

import java.util.ArrayList;

public class Task3 {

	//Stwórz dwie ArrayListy i każdą z nich wypełnij dziesięcioma imionami.
	// Wypisz te imiona, które są obecne w obu listach
	// nie korzystając z metod retainAll(), filter() oraz contains().

	public static void main(String[] args) {

		ArrayList<String> names1 = new ArrayList<>();
		names1.add("Mariusz");
		names1.add("Mikołaj");
		names1.add("Monika");
		names1.add("Kamila");
		names1.add("Michał");
		names1.add("Kamil");
		names1.add("Alicja");
		names1.add("Piotr");
		names1.add("Magda");
		names1.add("Krzysztof");

		ArrayList<String> names2 = new ArrayList<>();
		names2.add("Mariusz");
		names2.add("Kamil");
		names2.add("Agata");
		names2.add("Kamila");
		names2.add("Michał");
		names2.add("Piotr");
		names2.add("Magda");
		names2.add("Krzysztof");
		names2.add("Monika");
		names2.add("Andrzej");

		ArrayList<String> sameNames = new ArrayList<>();

		for (String name1 : names1) {
			for (String name2 : names2) {
				if (name1.equals(name2)) {
					sameNames.add(name1);
				}
			}
		}

		System.out.println("Te imiona występują w obu listach: ");
		for (String name : sameNames) {
			System.out.println(name);
		}
	}
}
