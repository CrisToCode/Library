package LibraryApp;

import java.util.List;

public class ISBNFirstPrintBooksStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> books) {
        books.forEach(book -> System.out.println(book.getISBN() + "\t"+ book.getTitle() + "\t"+ book.getPublicationYear()));
    }
}
