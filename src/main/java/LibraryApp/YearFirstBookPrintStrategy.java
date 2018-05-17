package LibraryApp;

import java.util.List;

public class YearFirstBookPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> books) {
        books.forEach(book -> System.out.println(book.getPublicationYear() + "\t" + book.getTitle() + "\t" + book.getISBN()));
    }
}
