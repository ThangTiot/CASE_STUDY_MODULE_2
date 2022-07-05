package Object;

public class Category {
    public static int ID_CATEGORY = 1;
    private String name;
    private int id;

    public Category() {
    }

    public Category(String name) {
        this.id = ID_CATEGORY++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
