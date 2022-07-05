package Manager;

import Object.Category;
import System.CRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryManage implements CRUD<Category> {
    Scanner scanner;
    ArrayList<Category> categoryArrayList;

    public CategoryManage() {
        scanner = new Scanner(System.in);
        categoryArrayList = new ArrayList<>();
    }

    @Override
    public Category creat() {
        System.out.println("Nhập tên mặt hàng: ");
        String name = scanner.nextLine();
        Category category = new Category(name);
        return category;
    }

    @Override
    public void add(Category category) {

    }

    @Override
    public void displayAll() {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public Category searchByID(int id) {
        return null;
    }
}
