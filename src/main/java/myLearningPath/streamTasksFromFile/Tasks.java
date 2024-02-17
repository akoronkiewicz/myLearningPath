package myLearningPath.streamTasksFromFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tasks {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("src/main/resources/data.txt");
		List<String> text = Files.readAllLines(path);
		List<User> users = new ArrayList<>();

		for (int i = 0; i < text.size(); i++) {
			if (i == 0) {
				continue;
			}
			String line = text.get(i);
			String[] parts = line.split(";");
			User user = new User(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
			users.add(user);
		}

		System.out.println("--- 1. Wyświetl komentarze w kolejności chronologicznej. ---");

		users.stream()
				.sorted(Comparator.comparing(User::date))
				.map(User::comment)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("--- 2. Wyświetl tylko te komentarze, które mają więcej niż 10 polubień. ---");

		users.stream()
				.filter(User -> User.likes() > 10)
				.map(User::comment)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("--- 3. Znajdź najdłuższy oraz najkrótszy komentarz. ---");

		String longestComment = users.stream()
				.map(User::comment)
				.max(Comparator.comparing(String::length))
				.orElse("");

		String shortestComment = users.stream()
				.map(User::comment)
				.min(Comparator.comparing(String::length))
				.orElse("");

		System.out.println("Najdłuższy komentarz: " + longestComment);
		System.out.println("Najkrótszy komentarz: " + shortestComment);

		System.out.println();
		System.out.println("--- 4. Oblicz średnią liczbę polubień dla wszystkich komentarzy. ---");

		Double averageLikes = users.stream()
				.collect(Collectors.averagingInt(User::likes));

		System.out.println(averageLikes);

		System.out.println();
		System.out.println("--- 5. Oblicz ile komentarzy zostało dodanych przez mężczyzn i kobiety. ---");

		long menComments = users.stream()
				.filter(User -> !User.username().endsWith("a"))
				.map(User::comment)
				.count();

		long womenComments = users.stream()
				.filter(User -> User.username().endsWith("a"))
				.map(User::comment)
				.count();

		System.out.println("Ilość komentarzy dodanych przez mężczyzn: " + menComments);
		System.out.println("Ilość komentarzy dodanych przez kobiety: " + womenComments);

		System.out.println();
		System.out.println("--- 6. Oblicz łączną liczbę polubień dla wszystkich komentarzy. ---");

		int sumOfLikes = users.stream()
				.mapToInt(User::likes)
				.sum();

		System.out.println(sumOfLikes);

		System.out.println();
		System.out.println("--- 7. Znajdź wszystkich użytkowników, którzy zostawili komentarze o długości przekraczającej 50 znaków. ---");

		users.stream()
				.filter(User -> User.comment().length() > 50)
				.map(User::username)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("--- 8. Posortuj komentarze według liczby polubień w kolejności malejącej. ---");

		users.stream()
				.sorted(Comparator.comparingInt(User::likes).reversed())
				.map(User::comment)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("--- 9. Wyświetl komentarze dodane w październiku 2023. ---");

		users.stream()
				.filter(user -> user.date().contains("2023-10"))
				.map(User::comment)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("---  10. Wyświetl unikalne daty, w których zostawiono komentarze. ---");

		users.stream()
				.map(User::date)
				.distinct()
				.forEach(System.out::println);

		System.out.println();
		System.out.println("---  11. Oblicz sumę polubień dla komentarzy zostawionych w listopadzie 2023. ---");

		int likesInNovember = users.stream()
				.filter(user -> user.date().contains("2023-11"))
				.mapToInt(User::likes)
				.sum();

		System.out.println(likesInNovember);

		System.out.println();
		System.out.println("---  12. Wyświetl wszystkie unikalne imiona użytkowników. ---");

		users.stream()
				.map(User::username)
				.distinct()
				.forEach(System.out::println);

		System.out.println();
		System.out.println("---  13. Oblicz średnią długość komentarzy. ---");

		Double averageCommentsLength = users.stream()
				.mapToDouble(user -> user.comment().length())
				.average()
				.orElse(0);

		System.out.println(averageCommentsLength);

		System.out.println();
		System.out.println("---  14. Oblicz średnią liczbę słów na komentarz. ---");

		double averageWords = users.stream()
				.mapToInt(user -> user.comment().split("\\s").length)
				.average()
				.orElse(0);

		System.out.println(averageWords);

		System.out.println();
		System.out.println("---  15. Wyświetl komentarze, które zawierają przynajmniej jedno słowo zaczynające się na literę 's'. ---");

		users.stream()
				.filter(user -> user.comment().matches(".*\\bs\\w*.*"))
				.forEach(user -> System.out.println(user.comment()));

		System.out.println();
		System.out.println(" ---  16. Wyświetl komentarze użytkowników, których imiona zawierają literę 'a' (bez względu na wielkość liter). ---");

		users.stream()
				.filter(user -> user.username().toLowerCase().contains("a"))
				.map(User::comment)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("---  17. Posortuj komentarze według długości komentarza, a następnie wybierz 5 najdłuższych. ---");

		users.stream()
				.map(User::comment)
				.sorted(Comparator.comparingInt(String::length).reversed())
				.limit(5)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("---  18. Posortuj komentarze alfabetycznie według nazw użytkowników, a następnie wybierz 5 pierwszych komentarzy w alfabetycznym porządku. ---");

		users.stream()
				.sorted(Comparator.comparing(User::username))
				.limit(5)
				.map(User::comment)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("---  19. Znajdź wszystkich użytkowników, którzy zostawili komentarze o długości przekraczającej średnią długość komentarzy. ---");

		double averageLengthComment = users.stream()
				.mapToInt(User -> User.comment().length())
				.average()
				.orElse(0);

		users.stream()
				.filter(user -> user.comment().length() > averageLengthComment)
				.map(User::username)
				.forEach(System.out::println);

		System.out.println();
		System.out.println("---  20. Znajdź datę, w której zostawiono najwięcej komentarzy. ---");

		Map<String, Long> collect = users.stream()
				.collect(Collectors.groupingBy(User::date, Collectors.counting()));

		String s = collect.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.map(Map.Entry::getKey)
				.orElse("");

		System.out.println(s);
	}
}
