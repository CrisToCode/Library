package LibraryApp;

public class Category {

    int id;

    String categoryName;

    int priority;

    public Category(int id, String categoryName, int priority) {
        this.id = id;
        this.categoryName = categoryName;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return
                " categoryName = '" + categoryName + '\'';
    }
}
