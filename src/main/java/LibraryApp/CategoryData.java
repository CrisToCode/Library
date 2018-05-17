package LibraryApp;

import java.util.List;

public class CategoryData {

    private  static CategoryData instance = new CategoryData();

    private CategoryData(){}

    private List<Category> categoryList;

    public static CategoryData getInstance(){
        return instance;
    }

    public void setCategoryList(List<Category> categoryList){
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }
}
