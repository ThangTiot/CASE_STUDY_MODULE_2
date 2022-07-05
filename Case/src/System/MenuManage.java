package System;

import java.util.ArrayList;
import java.util.Scanner;

import Manager.AccountManage;
import Manager.CustomerManage;
import Manager.ProductManage;
import Object.*;

public class MenuManage {
    CustomerManage customerManage;
    ProductManage productManage;
    AccountManage accountManage;
    Scanner scanner;

    public MenuManage() {
        scanner = new Scanner(System.in);
        customerManage = new CustomerManage();
        productManage = new ProductManage();
        accountManage = new AccountManage();
    }

    public void menuAdmin() {
        int choiceMenu;
        do {
            System.out.println("---------- XIN CHÀO SẾP ------------");
            System.out.println("1. Thao tác với khách hàng.");
            System.out.println("2. Thao tác với sản phẩm.");
            System.out.println("3. Đăng xuất.");
            choiceMenu = Integer.parseInt(scanner.nextLine());
            switch (choiceMenu) {
                case 1:
                    int choiceCustomer;
                    do {
                        System.out.println("---------- XIN CHÀO SẾP ------------");
                        System.out.println("1. Xem toàn bộ khách hàng.");
                        System.out.println("2. Tìm kiếm khách hàng qua ID.");
                        System.out.println("3. Xóa khách hàng qua ID.");
                        System.out.println("4. Thoát.");
                        choiceCustomer = Integer.parseInt(scanner.nextLine());
                        switch (choiceCustomer) {
                            case 1:
                                customerManage.displayAll();
                                break;
                            case 2:
                                searchCustomerByID();
                                break;
                            case 3:
                                deleteCustomerByID();
                            case 4:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (choiceCustomer != 4);
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
                                createProduct();
                                break;
                            case 2:
                                searchProductByID();
                                break;
                            case 3:
                                searchProductByName();
                                break;
                            case 4:
                                productManage.displayAll();
                                break;
                            case 5:
                                updateProductByID();
                                break;
                            case 6:
                                deleteProductByID();
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

    public void menuCustomer(Customer customer) {
        int choice;
        do {
            System.out.println("---------- CHÀO MỪNG BẠN ĐẾN VỚI BÁCH HÓA VÔ DỤNG ------------");
            System.out.println("1. Thay đổi thông tin cá nhân.");
            System.out.println("2. Bắt đầu mua sắm.");
            System.out.println("3. Đăng xuất.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    int choiceChangeInfo;
                    do {
                        System.out.println(customer);
                        System.out.println("1. Thay đổi thông tin cá nhân.");
                        System.out.println("2. Thay đổi thông tin tài khoản.");
                        System.out.println("3. Hoàn thành.");
                        choiceChangeInfo = Integer.parseInt(scanner.nextLine());
                        switch (choiceChangeInfo) {
                            case 1:
                                customerManage.update(customer);
                                break;
                            case 2:
                                Account account = customer.getAccount();
                                accountManage.update(account);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                                break;
                        }
                    } while (choiceChangeInfo != 3);
                    break;
                case 2:
                    int choiceProduct;
                    do {
                        System.out.println("---------- CHÀO MỪNG BẠN ĐẾN VỚI BÁCH HÓA VÔ DỤNG ------------");
                        System.out.println("1. Hiển thị toàn bộ sản phẩm.");
                        System.out.println("2. Tìm kiếm sản phẩm qua mã sản phẩm.");
                        System.out.println("3. Tìm kiếm sản phẩm theo tên bât kỳ.");
                        System.out.println("4. Mua hàng.");
                        System.out.println("5. Thanh toán.");
                        System.out.println("6. Xem đơn hàng.");
                        System.out.println("7. Thoát.");
                        choiceProduct = Integer.parseInt(scanner.nextLine());
                        switch (choiceProduct) {
                            case 1:
                                productManage.displayAll();
                                break;
                            case 2:
                                searchProductByID();
                                break;
                            case 3:
                                searchProductByName();
                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:

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
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 3);
    }

    public void searchCustomerByID() {
        System.out.println("Nhập ID khách hàng muốn tìm: ");
        int idFind = Integer.parseInt(scanner.nextLine());
        System.out.println(customerManage.searchByID(idFind));
    }

    public void deleteCustomerByID() {
        System.out.println("Nhập ID khách hàng muốn xóa: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        customerManage.delete(customerManage.searchByID(idDelete));
        customerManage.displayAll();
    }

    public void createProduct() {
        productManage.add(productManage.creat());
        productManage.displayAll();
    }

    public void searchProductByID() {
        System.out.println("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.println(productManage.searchByID(id));
    }
    public void searchProductByName() {
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
    }

    public void updateProductByID() {
        System.out.println("Nhập mã sản phẩm muốn sửa: ");
        String idUpdateProduct = scanner.nextLine();
        productManage.update(productManage.searchByID(idUpdateProduct));
        productManage.displayAll();
    }

    public void deleteProductByID() {
        System.out.println("Nhập mã sản phẩm muốn xóa: ");
        String idDeleteProduct = scanner.nextLine();
        productManage.delete(productManage.searchByID(idDeleteProduct));
        productManage.displayAll();
    }
}

