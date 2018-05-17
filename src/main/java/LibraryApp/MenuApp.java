package LibraryApp;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuApp {


    public static void printMenu() {
        System.out.println("Witamy w księgarni Biały Kruk");
        System.out.println("Wybierz jedną z opcji: ");
        System.out.println("1. Wejście");
        System.out.println("2. Wyświetl bibliotekę");
        System.out.println("3. Wyświetl książki przed danym rokiem");
        System.out.println("4. Wyświetl książki posortowane według roku wydania malejąco");
        System.out.println("5. Wyświetl książki posortowane według roku wydania rosnąco");
        System.out.println("6. Wyświetl książki według wybranej opcji: TitleFirst");
        System.out.println("7. Wyświetl książki według wybranej opcji: ISBNFirst");
        System.out.println("8. Wyświetl książki według wybranej opcji: YearFirst");
        System.out.println("9. Wyświetl wszystkie kategorie");
        System.out.println("10. Wyświetl książki z kategori `Wzorce projektowe`");
        System.out.println("11. Dodaj nowego autora");
        System.out.println("12. Wypisz wszystkich autorów");
        System.out.println("13. Wypisz autorów oraz liczbę książek, które wydali");
        System.out.println("14. Edycja nazwy książki");
        System.out.println("15. Wyjście");
    }


    public void chooseOption(BookData bookData, AuthorData authorData, CategoryData categoryData) {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        MenuApp menuApp = new MenuApp();
        ImportFile importFile = new ImportFile();
        BooksPrinter booksPrinter = new BooksPrinter(new TitleFirstBooksPrintStrategy());
        authorData.setAuthorList(importFile.authorsReader());
        categoryData.setCategoryList(importFile.categoryReader());
        bookData.setBookList(importFile.booksReader());


        while (option != 15) {

            switch (option) {
                case 1:
                    System.out.println("bialykruk@gmail.com");
                    break;
                case 2:
                    booksPrinter.printBooks(bookData.getAllBooks());
                    break;
                case 3:
                    System.out.println("Podaj rok książek: ");
                    int year = scanner.nextInt();
                    System.out.println("Książki przed rokiem: " + year);
                    bookData.filterBooksWithLambda(year);
                    break;
                case 4:
                    bookData.sortBooksByPublicationYearEarliest();
                    break;
                case 5:
                    bookData.sortBooksByPublicationYearLatest();
                    break;
                case 6:
                    booksPrinter.setBookPrintStrategy(new TitleFirstBooksPrintStrategy());
                    break;
                case 7:
                    booksPrinter.setBookPrintStrategy(new ISBNFirstPrintBooksStrategy());
                    break;
                case 8:
                    booksPrinter.setBookPrintStrategy(new YearFirstBookPrintStrategy());
                    break;
                case 9:
                    booksPrinter.showCategories(categoryData.getCategoryList());
                    break;
                case 10:
                    booksPrinter.printBooks(booksPrinter.showBooksFromDesignPaternCategory(bookData.getAllBooks()));
                    break;
                case 11:
                    scanner = new Scanner(System.in);
                    System.out.println("Podaj imię i nazwisko nowego autora");
                    String newAuthorsName;
                    newAuthorsName = scanner.nextLine();
                    System.out.println("Podaj jego wiek");
                    int age;
                    age = scanner.nextInt();
                    authorData.addNewAuthor(authorData.getAuthorList(), newAuthorsName, age);
                    break;
                case 12:
                    booksPrinter.showAuthors(authorData.getAuthorList());
                    break;
                case 13:
                    booksPrinter.showAuthorsAndBooksTheyWrote(bookData.getAllBooks(), authorData.getAuthorList());
                    break;
                case 14:
                    bookData.editBooksTitle();
                    break;
                case 15:
                    break;
            }
            printMenu();
            option = scanner.nextInt();
        }
    }

    private static void showBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    private static void showAuthor(List<Author> authorList) {
        for (Author author : authorList) {
            System.out.println(author);
        }
    }


    public static void main(String[] args) {

        MenuApp menu = new MenuApp();

        printMenu();

        BookData bookData = BookData.getInstance();
        AuthorData authorData = AuthorData.getInstance();
        CategoryData categoryData = CategoryData.getInstance();

        menu.chooseOption(bookData, authorData, categoryData);

        //showAuthor();
    }
}

