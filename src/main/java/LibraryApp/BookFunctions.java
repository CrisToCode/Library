package LibraryApp;

import java.security.PublicKey;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class BookFunctions {

    public Book searchISBNNumber(List<Book> books, String ISBN) {
        Book varBook;
        varBook = books.stream().filter(book -> book.getISBN().equals(ISBN)).findFirst().get();
        return varBook;
    }

    public List<Book> sortBooksByPublicationYearEarliest(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear)).collect(Collectors.toList());
    }

    public List<Book> getTwoLastBooks(List<Book> books) {
        return books.stream().skip(books.size() - 2).collect(Collectors.toList());
    }

    public List<Book> sortBooksByPublicationYearLatest(List<Book> books) {
        return books.stream().sorted(Comparator.comparing(Book::getPublicationYear).reversed()).collect(Collectors.toList());
    }

    public Book giveErliestPublishedBook(List<Book> books) {
        Book varBook;
        varBook = books.stream().sorted(Comparator.comparing(Book::getPublicationYear).reversed()).findFirst().get();
        return varBook;
    }

    public Book giveLatestPublishedBook(List<Book> books) {
        Book varBook;
        varBook = books.stream().sorted(Comparator.comparing(Book::getPublicationYear)).findFirst().get();
        return varBook;
    }

    public int getYearsSumOfAllBooks(List<Book> books) {
        int sum = books.stream().mapToInt(Book::getPublicationYear).sum();
        return sum;
    }

    public long getBooksPubliesheAfter2007(List<Book> books, int year) {
        long counter = books.stream().filter(book -> book.getPublicationYear() > year).count();
        return counter;
    }

    public long areBooksPublisheBefore2000(List<Book> books, int year) {
        long counter = books.stream().filter(book -> book.getPublicationYear() < year).count();
        return counter;
    }
    public double getAverageYearOfPublishedBooks(List<Book> books) {
        return books.stream().mapToDouble(book->book.getPublicationYear()).average().getAsDouble();
    }
    public boolean isAnyBookPublishedBefore2000(List<Book> books, int year){
        return  books.stream().anyMatch(book -> book.getPublicationYear()<year);

    }
    public List<Book> giveAllBooksTitlesStartWithTAndArePublishedAfter2009(List<Book> books, int year){
        return books.stream().filter(book -> book.getTitle().startsWith("t"))
                .filter(book -> book.getPublicationYear()>year)
                .collect(Collectors.toList());
    }
    public  List<Book>  adding100YearsToPublishedYear(List<Book> books, int years){
        books.stream().forEach(book -> book.setPublicationYear(book.getPublicationYear()+years));
        return books;
    }
    public List<String> getAllTitlesThatPublishedYearIsDividableBy2(List<Book> books){
       return books.stream().filter(book -> book.getPublicationYear()%2==0)
                .map(book -> book.getTitle())
                .collect(Collectors.toList());


    }
}
