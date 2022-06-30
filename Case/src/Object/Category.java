package Object;

public class Category {
    private static int ID_CATEGORY = 1;
    private int id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.id = ID_CATEGORY++;
        this.name = name;
    }

    public static int getIdCategory() {
        return ID_CATEGORY;
    }

    public static void setIdCategory(int idCategory) {
        ID_CATEGORY = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
