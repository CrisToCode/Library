package LibraryApp;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookData {


    private static BookData instance = new BookData();

    private BookData() {
    }

    private List<Book> bookList;

    public static BookData getInstance() {

        return instance;
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }


    public void sortBooksByPublicationYearEarliest() {
        bookList.stream().sorted(Comparator.comparing(Book::getPublicationYear)).collect(Collectors.toList())
                .forEach(book -> System.out.println(book));
    }
    public void sortBooksByPublicationYearLatest() {
        bookList.stream().sorted(Comparator.comparing(Book::getPublicationYear).reversed()).collect(Collectors.toList())
                .forEach(book -> System.out.println(book));
    }
    //edycja nazwy książki
    public void editBooksTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę książki, którą chcesz zmienić: ");
        String oldBooksTitle = scanner.nextLine();
        System.out.println("Podaj nową nazwę dla książki: ");
        String newBooksTitle = scanner.nextLine();

        for(Book book1: bookList){
            if(book1.getTitle().equals(oldBooksTitle)){
                book1.setTitle(newBooksTitle);
            }
        }
        System.out.println(bookList);
    }
}

