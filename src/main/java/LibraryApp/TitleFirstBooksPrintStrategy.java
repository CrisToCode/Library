package LibraryApp;

import java.util.List;

public class TitleFirstBooksPrintStrategy implements BookPrintStrategy {
    @Override
    public void print(List<Book> books) {
        books.forEach(book -> System.out.println("Title= "+ book.getTitle()  +" ISBN= "+ book.getIsbn()  + " Publication Year= " + book.getPublicationYear()  + " bookCover= "+ book.getBookCover() + book.getAuthorList()  + book.getCategory()));
    }
}
