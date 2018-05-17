package LibraryApp;

import java.util.List;

public class Book {

    private String title;

    private String isbn;

    private int publicationYear;

    private String bookCover;

    private List<Author> authorList;

    public String getBookCover() {
        return bookCover;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public Category getCategory() {
        return category;
    }

    private Category category;

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Book(String title, String Isbn, int publicationYear, String bookCover, List<Author> authorList, Category category) {
        this.title = title;
        this.isbn = Isbn;
        this.publicationYear = publicationYear;
        this.bookCover = bookCover;
        this.authorList = authorList;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title= '" + title  +
                ", isbn= '" + isbn  +
                ", publicationYear= " + publicationYear +
                ", bookCover= " + bookCover  +
                ", authorList= " + authorList +
                ", category= " + category +
                '}';
    }
}
