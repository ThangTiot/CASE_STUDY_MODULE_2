package System;

import java.util.ArrayList;
import java.util.Scanner;

import Manager.*;
import Object.Product;

public class MenuManage {
    CustomerManage customerManage;
    ProductManage productManage;
    Scanner scanner;

    public MenuManage() {
        scanner = new Scanner(System.in);
        customerManage = new CustomerManage();
        productManage = new ProductManage();
    }

    public void menuAdmin() {
        int choiceMenu;
        do {
            System.out.println("---------- CHÀO MỪNG SẾP ------------");
            System.out.println("1. Thao tác với khách hàng.");
            System.out.println("2. Thao tác với sản phẩm.");
            System.out.println("3. Đăng xuất.");
            choiceMenu = Integer.parseInt(scanner.nextLine());
            switch (choiceMenu) {
                case 1:
                    int choiceCustomer;
                    do {
                        System.out.println("---------- CHÀO MỪNG SẾP ------------");
                        System.out.println("1. Xem toàn bộ khách hàng.");
                        System.out.println("2. Tìm kiếm khách hàng qua ID.");
                        System.out.println("3. Thoát.");
                        choiceCustomer = Integer.parseInt(scanner.nextLine());
                        switch (choiceCustomer) {
                            case 1:
                                customerManage.displayAll();
                                break;
                            case 2:
                                System.out.println("Nhập ID khách hàng: ");
                                int id = Integer.parseInt(scanner.nextLine());
                                System.out.println(customerManage.searchByID(id));
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (choiceCustomer != 3);
                    break;
                case 2:
                    int choiceProduct;
                    do {
                        System.out.println("---------- CHÀO MỪNG SẾP ------------");
                        System.out.println("1. Thêm sản phẩm.");
                        System.out.println("2. Tìm kiếm sản phẩm qua mã sản phẩm.");
                        System.out.println("3. Tìm kiếm sản phẩm theo tên bât kỳ.");
                        System.out.println("4. Hiển thị toàn bộ kho hàng.");
                        System.out.println("5. Sửa thông tin sản phẩm.");
                        System.out.println("6. Xóa sản phẩm.");
                        System.out.println("7. Thoát.");
                        choiceProduct = Integer.parseInt(scanner.nextLine());
                        switch (choiceProduct) {
                            case 1:
                                productManage.add(productManage.creat());
                                productManage.displayAll();
                                break;
                            case 2:
                                System.out.println("Nhập mã sản phẩm: ");
                                String id = scanner.nextLine();
                                System.out.println(productManage.searchByID(id));
                                break;
                            case 3:
                                System.out.println("Nhập tên sản phẩm: ");
                                String name = scanner.nextLine();
                                ArrayList<Product> products = productManage.searchByName(name);
                                productManage.display(products);
                                System.out.println("1. Sắp xếp theo giá tăng dần.");
                                System.out.println("2. Sắp xếp theo giá giảm dần.");
                                int choiceSort = Integer.parseInt(scanner.nextLine());
                                if (choiceSort == 1) {
                                    productManage.display(productManage.sortByIncrementalPrice(products));
                                } else {
                                    productManage.display(productManage.sortByDescendPrice(products));
                                }
                                break;
                            case 4:
                                productManage.displayAll();
                                break;
                            case 5:
                                System.out.println("Nhập mã sản phẩm muốn sửa: ");
                                String idUpdateProduct = scanner.nextLine();
                                productManage.update(productManage.searchByID(idUpdateProduct));
                                productManage.displayAll();
                                break;
                            case 6:
                                System.out.println("Nhập mã sản phẩm muốn xóa: ");
                                String idDeleteProduct = scanner.nextLine();
                                productManage.delete(productManage.searchByID(idDeleteProduct));
                                productManage.displayAll();
                                break;
                            case 7:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                                break;
                        }
                    } while (choiceProduct != 7);
                    break;
                case 3:
                    break;
            }
        } while (choiceMenu != 3);
    }

    public void menuCustomer() {
        System.out.println("Chua test.");
    }
}

