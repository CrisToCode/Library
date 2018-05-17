package LibraryApp;

import java.util.List;
import java.util.Scanner;

public class AuthorService {

    public void filterAuthorsByAge(List<Author> authorList, int age) {
        authorList.stream()
                .filter(author -> author.getAge() < age)
                .forEach(author -> System.out.println(author));
    }

    public void addNewAuthor(List<Author> authorList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię i nazwisko nowego autora");
        String newAuthorsName = scanner.nextLine();
        System.out.println("Podaj jego wiek");
        int age = scanner.nextInt();
        authorList.add(new Author(newAuthorsName, age));
    }

    public void showAuthors(List<Author> authorList) {
        for (Author author : authorList) {
            System.out.println(author);
        }
    }

}