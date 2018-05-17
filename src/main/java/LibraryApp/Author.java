package LibraryApp;

public class Author {

    private int ordinalNumber;

    private String name;

    private int age;

    private static int id = 0;

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Author(String name, int age) {
        id++;
        this.ordinalNumber = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author`s " +
                "{" + ordinalNumber + "." +
                "'" + name +
                '\'' + ", age= " + age + " }";
    }
}
