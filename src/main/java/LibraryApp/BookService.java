package LibraryApp;

import java.util.List;
import java.util.Scanner;

public class BookService {

    public void filterBooks(List<Book> bookList, int year){
        for (Book book : bookList ) {
            if(book.getPublicationYear()<year)
                System.out.println(book);
        }
    }
    public void filterBooksWithLambda(List<Book>bookList){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj rok książek: ");
        int year = scanner.nextInt();
        System.out.println("Książki przed rokiem: " + year);
        bookList.stream()
                .filter(book -> book.getPublicationYear()<year)
                .forEach(book -> System.out.println(book));
    }
}
