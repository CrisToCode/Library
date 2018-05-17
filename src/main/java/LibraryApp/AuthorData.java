package LibraryApp;

import java.util.List;

public class AuthorData  {

    private static AuthorData instance = new AuthorData();

    private AuthorData(){

    }
    private List<Author> authorList;

    public static AuthorData getInstance(){
        return instance;
    }
    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }
    public void filterAuthorsByAge(int age){
        authorList.stream()
                .filter(author -> author.getAge()<age)
                .forEach(author -> System.out.println(author));
    }
    public void addNewAuthor( List<Author> authorList, String newAuthorsName, int age){
        authorList.add(new Author(newAuthorsName, age));
    }
}
