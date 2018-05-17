package LibraryApp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BooksPrinter {

    BookPrintStrategy bookPrintStrategy;

    BooksPrinter(BookPrintStrategy bookPrintStrategy) {
        this.bookPrintStrategy = bookPrintStrategy;
    }

    public void setBookPrintStrategy(BookPrintStrategy bookPrintStrategy) {
        this.bookPrintStrategy = bookPrintStrategy;
    }

    public void printBooks(List<Book> books) {
        bookPrintStrategy.print(books);
    }

    public void showCategories(List<Category> categoryList) {
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    public List<Book> showBooksFromDesignPaternCategory(List<Book> bookList) {
        return bookList.stream().filter(book -> book.getCategory().getCategoryName().equals("Wzorce projektowe")).collect(Collectors.toList());
    }




    //Wyświetlenie autorów oraz liczby książek, które wydali

    public void showAuthorsAndBooksTheyWrote(List<Book> bookList, List<Author> authorList) {
        int booksCounter = 0;
        Map<Author, Integer> authorIntegerMap = new HashMap<>();

        for (Author author1 : authorList) {
            for (Book book1 : bookList) {
                if (book1.getAuthorList().contains(author1)) {
                    booksCounter++;
                }
            }
            authorIntegerMap.put(author1, booksCounter);
            booksCounter = 0;
        }
        System.out.println(authorIntegerMap);
    }
}
