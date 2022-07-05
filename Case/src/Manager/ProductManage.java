package Manager;

import Object.Product;
import System.CRUD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ProductManage implements CRUD<Product> {
    static String path = "E:\\CODE_GYM\\MODULE 2\\CASE_STUDY\\Case\\src\\Data\\Storage.txt";
    static ReadAndWrite<Product> readAndWriteProduct = new ReadAndWrite<>();
    static ArrayList<Product> productArrayList = readAndWriteProduct.read(path);
    Scanner scanner;
    public ProductManage() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Product creat() {
        System.out.println("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        while (checkIDProduct(id)) {
            System.out.println("Mã sản phẩm đã tồn tại.");
            System.out.println("Nhập lại mã: ");
            id = scanner.nextLine();
        }
        System.out.println("Tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Số lượng sản phẩm: ");
        int amount = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, name, price, amount);
        return product;
    }

    @Override
    public void add(Product product) {
        productArrayList.add(product);
        readAndWriteProduct.write(path,productArrayList);
    }

    @Override
    public void displayAll() {
        for (Product product : productArrayList) {
            System.out.println(product);
        }
    }

    @Override
    public void update(Product product) {
        System.out.println("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        while (checkIDProduct(id)) {
            System.out.println("Mã sản phẩm đã tồn tại.");
            System.out.println("Nhập lại mã: ");
            id = scanner.nextLine();
        }
        System.out.println("Tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Số lượng sản phẩm: ");
        int amount = Integer.parseInt(scanner.nextLine());
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setAmount(amount);
        readAndWriteProduct.write(path,productArrayList);
    }

    @Override
    public void delete(Product product) {
        System.out.println("Bạn có muốn xóa sản phẩm không?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            productArrayList.remove(product);
            System.out.println("Xóa sản phẩm thành công!");
        }
        readAndWriteProduct.write(path,productArrayList);
    }
    public Product searchByID(String id) {
        for (Product product : productArrayList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
    public ArrayList<Product> searchByName(String name) {
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : productArrayList) {
            String productName = product.getName().toUpperCase();
            if (productName.contains(name)) {
                System.out.println(product);
                products.add(product);
            }
        }
        return products;
    }

    public ArrayList<Product> sortByIncrementalPrice(ArrayList<Product> products) {
        Collections.sort(products);
        return products;
    }

    public ArrayList<Product> sortByDescendPrice(ArrayList<Product> products) {
        ArrayList<Product> newProducts = sortByIncrementalPrice(products);
        Collections.reverse(newProducts);
        return newProducts;
    }

    public boolean checkIDProduct(String id) {
        if (searchByID(id) != null) {
            return true;
        }
        return false;
    }

    public void display(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Override
    public Product searchByID(int id) {
        return null;
    }
}
