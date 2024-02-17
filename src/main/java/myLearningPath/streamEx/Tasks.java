package myLearningPath.streamEx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {
	public static void main(String[] args) {


		List<User> users = prepareData();

		//		1. Wyświetl imiona użytkowników, którzy znają Jave.
		System.out.println("Zadanie 1: ");

		users.stream()
				.filter(user -> user.skills().contains("Java"))
				.map(User::name)
				.forEach(System.out::println);

		System.out.println();

		//		2. Wyświetl imiona i wiek nieaktywnych użytkowników.
		System.out.println("Zadanie 2:");

		users.stream()
				.filter(user -> !user.isActive())
				.map(user -> user.name() + ", " + user.age())
				.forEach(System.out::println);

		System.out.println();

		//		3. Znajdź użytkowników, którzy znają co najmniej 3 języki,
//		   wyświetl imiona tych użytkowników oraz języki, które znają.
		System.out.println("Zadanie 3: ");

		users.stream()
				.filter(user -> user.skills().size() > 3)
				.map(user -> user.name() + ": " + String.join(", ", user.skills()))
				.forEach(System.out::println);

		System.out.println();


		//		4. Znajdź użytkownika, który zna najwięcej technologii
//		   Wyświetl jego imię oraz listę technologii.
		System.out.println("Zadanie 4: ");

		Optional<User> max = users.stream()
				.max(Comparator.comparing(user -> user.skills().size()));

		System.out.println(max.get().name() + ": " + String.join(", ", max.get().skills()));
		System.out.println();


		//		5. Wyświetl średni wiek aktywnych użytkowników
		System.out.println("Zadnie 5: ");

		Double averageAge = users.stream()
				.filter(User::isActive)
				.collect(Collectors.averagingInt(User::age));

		System.out.println(averageAge);
		System.out.println();


		//		6. Wyświetl średni wiek nieaktywnych użytkowników
		System.out.println("Zadanie 6: ");

		Double nonAverageAge = users.stream()
				.filter(user -> !user.isActive())
				.collect(Collectors.averagingInt(User::age));

		System.out.println(nonAverageAge);
		System.out.println();


		//		7. Wyświetl ile średnio technologii zna użytkownik
		System.out.println("Zadanie 7: ");

		OptionalDouble averageSkills = users.stream()
				.mapToInt(user -> user.skills().size())
				.average();

		System.out.println(averageSkills.getAsDouble());
		System.out.println();


//		8. Podziel użytkowników na tych, którzy znają Jave
//		   oraz tych, którzy Javy nie znają. Wyświetl imiona
//		   oraz technologie tych użytkowników z obu grup.
		System.out.println("Zadanie 8: ");

		Map<Boolean, List<User>> usersMap = users.stream()
				.collect(Collectors.partitioningBy(user -> user.skills().contains("Java")));

		usersMap.get(true).stream()
				.map(user -> user.name() + ": " + String.join(". ", user.skills()))
				.forEach(System.out::println);
		System.out.println();

		usersMap.get(false).stream()
				.map(user -> user.name() + ": " + String.join(". ", user.skills()))
				.forEach(System.out::println);
		System.out.println();


//		9. Sprawdź, czy wszyscy użytkownicy mają więcej niż 18 lat.
		System.out.println("Zadanie 9: ");

		boolean over = users.stream()
				.allMatch(user -> user.age() > 18);

		System.out.println(over);
		System.out.println();


//		10. Sprawdź, czy istnieje użytkownik, który ma 40 lub więcej lat.
		System.out.println("Zadanie 10: ");

		boolean userWith40OrMore = users.stream()
				.anyMatch(user -> user.age() >= 40);

		System.out.println(userWith40OrMore);
		System.out.println();


//		11. Znajdź najstarszego użytkownika, który zna Jave.
		System.out.println("Zadanie 11: ");

		Optional<User> oldestJava = users.stream()
				.filter(user -> user.skills().contains("Java"))
				.max(Comparator.comparing(User::age));

		System.out.println(oldestJava.get().name() + " " + oldestJava.get().age());
		System.out.println();


//		12. Znajdź użytkowników znających języki, których nazwy zaczynają się na literę C.
//		    Wyświetl imiona oraz technologie tych użytkowników.
		System.out.println("Zadanie 12: ");

		users.stream()
				.filter(user -> user.skills().stream().anyMatch(skill -> skill.startsWith("C")))
				.map(user -> user.name() + ": " + String.join(", ", user.skills()))
				.forEach(System.out::println);

		System.out.println();


//		13. Utwórz mapę, która jako klucz otrzyma imię użytkownika,
//	    	a jako wartość liczbę technologii, które zna użytkownik.
		System.out.println("Zadanie 13: ");

		Map<String, Integer> usersKeyAndValue = users.stream()
				.collect(Collectors.toMap(User::name, user -> user.skills().size()));

		System.out.println(usersKeyAndValue);
		System.out.println();

//		14. Wybierz z podanej listy słowa, które są palindromami
		System.out.println("Zadanie 14: ");

		List<String> words = List.of("kajak", "oko", "komputer", "ala", "zakaz", "java", "programowanie");

		words.stream()
				.filter(word -> word.contentEquals(new StringBuilder(word).reverse()))
				.forEach(System.out::println);
		System.out.println();


//		15. Wyświetl wszystkie słowa z podanej listy, oddziel je przecinkami,
//	    	zadbaj o to, aby zamienić wszystkie litery na duże.
		System.out.println("Zadanie 15: ");

		String allWords = words.stream()
				.map(String::toUpperCase)
				.collect(Collectors.joining(", "));

		System.out.println(allWords);
		System.out.println();


//		16. Mając 2 listy liczb całkowitych, znajdź najmniejszą liczbę parzystą.
		System.out.println("Zadanie 16: ");

		List<Integer> list1 = List.of(62, 55, 120, 17, 7, 11);
		List<Integer> list2 = List.of(42, 27, 35, 98);

		Integer integer = Stream.concat(list1.stream(), list2.stream())
				.sorted()
				.filter(number -> number % 2 == 0)
				.findFirst()
				.get();

		System.out.println(integer);
	}

	private static List<User> prepareData() {
		List<User> users = new ArrayList<>();

		users.add(new User("Kamil", 35, List.of("Java", "Python", "JavaScript"), true));
		users.add(new User("Mariusz", 30, List.of("Java", "C++", "C#"), true));
		users.add(new User("Dominik", 20, List.of("Java", "Dart", "Python"), false));
		users.add(new User("Rafał", 40, List.of("C", "C++", "C#"), true));
		users.add(new User("Paulina", 31, List.of("Python", "JavaScript", "Rust"), true));
		users.add(new User("Kasia", 30, List.of("PHP", "Haskell"), false));
		users.add(new User("Asia", 25, List.of("Java", "Scala", "Kotlin", "Haskell", "Clojure"), true));

		return users;
	}
}
