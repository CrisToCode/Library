package LibraryApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImportFile {

    public List<Category> categoryReader() {
        BufferedReader brCategory = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("categories.csv")));
        List<Category> categoryList = new ArrayList<>();
        try {
            String line = brCategory.readLine();
            categoryReaderHowTo(brCategory, categoryList, line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    private void categoryReaderHowTo(BufferedReader brCategory, List<Category> categoryList, String line) throws IOException {
        while (line != null) {
            Category category;
            String[] lineInFileCategory = line.split(";");
            int id = Integer.parseInt(lineInFileCategory[0]);
            String categoryName = lineInFileCategory[1];
            int priority = Integer.parseInt(lineInFileCategory[2]);
            category = new Category(id, categoryName, priority);
            categoryList.add(category);
            line = brCategory.readLine();
        }
    }

    public List<Author> authorsReader() {//z pliku w source wczytuje dane
        BufferedReader brAuthors = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("authors.csv")));
        List<Author> authorList = new ArrayList<>();
        try {
            String line = brAuthors.readLine();
            authorsReaderHowTo(brAuthors, authorList, line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    private void authorsReaderHowTo(BufferedReader brAuthors, List<Author> authorList, String line) throws IOException {
        while (line != null) {//sposób wyświetlania danych z pliku authors.csv
            Author author;
            String[] lineInFileAuthor = line.split(";");
            String name = lineInFileAuthor[1];
            int age = Integer.parseInt(lineInFileAuthor[2]);
            author = new Author(name, age);
            authorList.add(author);
            line = brAuthors.readLine();
        }
    }

    public List<Book> booksReader() { //typ lista metody
        BufferedReader brBooks = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("books.csv")));
        List<Book> bookList = new ArrayList<>();

        try {
            String line = brBooks.readLine();
            booksReaderHowTo(brBooks, bookList, line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BookData.getInstance().setBookList(bookList);
        return bookList;
    }

    private void booksReaderHowTo(BufferedReader brBooks, List<Book> bookList, String line) throws IOException {

        AuthorData authorData = AuthorData.getInstance();
        CategoryData categoryData = CategoryData.getInstance();

        while (line != null) {
            Book book;
            String[] lineToken = line.split(";"); //podział stringa na tabelę
            String title = lineToken[0]; //tytuł do tabeli 0
            String ISBN = lineToken[1]; //numer isbn który jest stringiem robię na inta i dodaje do tabeli na drugie miejsce
            int publicationYear = Integer.parseInt(lineToken[2]);// rok publikacji parsuje na inta i dodaję n trzecie miejsce
            String cover = lineToken[3];
            String authorsID = lineToken[4];
            String[] authorsIDListFromBook = authorsID.split(",");
            String category = lineToken[5];

            List<Author> authorList1 = new ArrayList<>();
            for (int i = 0; i < authorsIDListFromBook.length; i++) {
                for (Author author1 : authorData.getAuthorList()) {
                    if (authorsIDListFromBook[i].equals(Integer.toString(author1.getOrdinalNumber()))) {
                        authorList1.add(author1);
                    }
                }
            }
                Category categories = new Category(1, "", 1);
                for (Category categories1 : categoryData.getCategoryList()) {
                    if (Integer.parseInt(category) == (categories1.getId())) {
                        categories = categories1;
                    }
                }

                book = new Book(title, ISBN, publicationYear, cover, authorList1, categories);
                bookList.add(book);
                line = brBooks.readLine();
            }
        }
    }
