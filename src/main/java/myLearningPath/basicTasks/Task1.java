package myLearningPath.basicTasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {


//		Stwórz program, w którym:
//		Zapytasz użytkownika, ile imion chce podać.
//		Pobierzesz te imiona i zapiszesz je do ArrayListy.
//		Wyświetlisz informację, ile jest na liście mężczyzn, a ile kobiet,
//		przyjmując że imiona kobiece kończą się na literę “a”.

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ile chcesz podać imion? ");
		int numberOfNames = scanner.nextInt();
		scanner.nextLine();

		ArrayList<String> names = new ArrayList<>();

		for (int i = 0; i < numberOfNames; i++) {
			System.out.println("Podaj imię " + (i + 1) + ": ");
			String name = scanner.nextLine();
			names.add(name);
		}

		int male = 0;
		int female = 0;

		for (String name : names) {
			if (name.endsWith("a")) {
				female++;
			} else {
				male++;
			}
		}
		System.out.println("Liczba mężczyzn: " + male);
		System.out.println("Liczba kobiet: " + female);
	}
}
