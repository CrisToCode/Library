package LibraryApp;

import java.util.List;

public class TitleFirstBooksPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> books) {
        books.forEach(book -> System.out.println("Title = "+ book.getTitle() + "\t" +"ISBN = "+ book.getISBN() + "\t" + "Publication Year = " + book.getPublicationYear() + "\t" + "bookCover = "+ book.getBookCover()+ "\t" + book.getAuthorList() + "\t" + book.getCategory()));
    }
}
