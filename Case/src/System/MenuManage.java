package System;

import java.util.ArrayList;
import java.util.Scanner;

import Manager.AccountManage;
import Manager.CustomerManage;
import Manager.OrderManage;
import Manager.ProductManage;
import Object.*;

public class MenuManage {
    CustomerManage customerManage;
    ProductManage productManage;
    AccountManage accountManage;
    OrderManage orderManage;
    Scanner scanner;

    public MenuManage() {
        scanner = new Scanner(System.in);
        customerManage = new CustomerManage();
        productManage = new ProductManage();
        accountManage = new AccountManage();
        orderManage = new OrderManage();
    }

    public void menuAdmin() {
        int choiceMenu;
        do {
            System.out.println("------------------------------------");
            System.out.println("---------- XIN CHÀO SẾP ------------");
            System.out.println("------------------------------------");
            System.out.println("1. Thao tác với khách hàng.");
            System.out.println("2. Thao tác với sản phẩm.");
            System.out.println("3. Thao tác với đơn hàng.");
            System.out.println("4. Đăng xuất.");
            choiceMenu = Integer.parseInt(scanner.nextLine());
            switch (choiceMenu) {
                case 1:
                    menuAdmin1();
                    break;
                case 2:
                    menuAdmin2();
                    break;
                case 3:
                    menuAdmin3();
                    break;
                case 4:
                    break;
            }
        } while (choiceMenu != 4);
    }

    public void menuCustomer(Customer customer) {
        int choice;
        do {
            System.out.println("--------------------------------------------------------------");
            System.out.println("---------- CHÀO MỪNG BẠN ĐẾN VỚI BÁCH HÓA VÔ DỤNG ------------");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Thay đổi thông tin cá nhân.");
            System.out.println("2. Bắt đầu mua sắm.");
            System.out.println("3. Đăng xuất.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuCustomer1(customer);
                    break;
                case 2:
                    menuCustomer2(customer);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choice != 3);
    }

//CÁC LỰA CHỌN CỦA ADMIN *******************************************************

    public void menuAdmin1() {
        int choiceCustomer;
        do {
            System.out.println("------------------------------------");
            System.out.println("---------- XIN CHÀO SẾP ------------");
            System.out.println("------------------------------------");
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
    }

    public void menuAdmin2() {
        int choiceProduct;
        do {
            System.out.println("------------------------------------");
            System.out.println("---------- XIN CHÀO SẾP ------------");
            System.out.println("------------------------------------");
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
    }

    public void menuAdmin3() {
        int choiceOrder;
        do {
            System.out.println("------------------------------------");
            System.out.println("---------- XIN CHÀO SẾP ------------");
            System.out.println("------------------------------------");
            System.out.println("1. Xem toàn bộ đơn hàng.");
            System.out.println("2. Tìm kiếm đơn hàng qua mã đơn hàng.");
            System.out.println("3. Tìm kiếm đơn hàng qua ID khách hàng.");
            System.out.println("4. Thoát.");
            choiceOrder = Integer.parseInt(scanner.nextLine());
            switch (choiceOrder) {
                case 1:
                    orderManage.displayAll();
                    break;
                case 2:
                    System.out.println("Nhập mã đơn hàng muốn tìm: ");
                    int idOrder = Integer.parseInt(scanner.nextLine());
                    orderManage.displayOrderByID(orderManage.searchByID(idOrder));
                    break;
                case 3:
                    System.out.println("Nhập ID khách hàng: ");
                    int idCustomerOfOrder = Integer.parseInt(scanner.nextLine());
                    ArrayList<Order> orders = orderManage.searchOrderOfCustomerByID(idCustomerOfOrder);
                    for (Order order : orders) {
                        orderManage.displayOrder(order);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choiceOrder != 4);
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

    //HẾT CÁC LỰA CHỌN CỦA ADMIN ******************************************************

    //CÁC LỰA CHỌN CỦA CUSTOMER *******************************************************

    public void menuCustomer1(Customer customer) {
        int choiceChangeInfo;
        do {
            System.out.println(customer);
            System.out.println("------------------------------");
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
    }

    public void menuCustomer2(Customer customer) {
        int choiceProduct;
        do {
            System.out.println("--------------------------------------------------------------");
            System.out.println("---------- CHÀO MỪNG BẠN ĐẾN VỚI BÁCH HÓA VÔ DỤNG ------------");
            System.out.println("--------------------------------------------------------------");
            System.out.println("1. Hiển thị toàn bộ sản phẩm.");
            System.out.println("2. Tìm kiếm sản phẩm qua mã sản phẩm.");
            System.out.println("3. Tìm kiếm sản phẩm theo tên bât kỳ.");
            System.out.println("4. Thêm sản phẩm vào giỏ hàng");
            System.out.println("5. Xem giỏ hàng.");
            System.out.println("6. Kiểm tra tình trạng đơn hàng.");
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
                    productManage.displayAll();
                    addProductInCart();
                    break;
                case 5:
                    displayCart(customer);
                    break;
                case 6:
                    checkOrder(customer);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (choiceProduct != 7);
    }

    public void addProductInCart() {
        System.out.println("Nhập mã sản phẩm muốn mua:");
        String idOrderProduct = scanner.nextLine();
        Product product = productManage.searchByID(idOrderProduct);
        while (!productManage.checkIDProduct(idOrderProduct)) {
            System.out.println("Mã sản phẩm không tồn tại.");
            System.out.println("Nhập lại mã sản phẩm:");
            idOrderProduct = scanner.nextLine();
        }
        System.out.println("Số lượng muốn mua: ");
        int amountOrderProduct = Integer.parseInt(scanner.nextLine());
        while (product.getAmount() < amountOrderProduct) {
            System.out.println("Số lượng vượt quá kho hàng có!");
            System.out.println("Nhập lại số lượng muốn mua (<" + product.getAmount() + "): ");
            amountOrderProduct = Integer.parseInt(scanner.nextLine());
        }
        if (orderManage.checkProductInCart(idOrderProduct) != null) {
            Product productExist = orderManage.checkProductInCart(idOrderProduct);
            int amountOrderProductExist = productExist.getAmount();
            while (product.getAmount() < (amountOrderProduct + amountOrderProductExist)) {
                System.out.println("Số lượng vượt quá kho hàng có!");
                System.out.println("Nhập lại số lượng muốn mua (<" + (product.getAmount() - amountOrderProductExist) + "): ");
                amountOrderProduct = Integer.parseInt(scanner.nextLine());
            }
            productExist.setAmount(productExist.getAmount() + amountOrderProduct);
            System.out.println("Đã thêm sản phẩm vào giỏ hàng.");
            System.out.println("Đến giỏ hàng để tiến hành thanh toán.");
        } else {
            orderManage.addToCart(product, amountOrderProduct);
        }
    }

    public void displayCart(Customer customer) {
        if (orderManage.getOrderProducts().size() == 0) {
            System.out.println("Bạn chưa có sản phẩm nào trong giỏ hàng!");
            System.out.println("Hãy quay lại mua sắm nhé.");
        } else {
            orderManage.displayCart();
            System.out.println("1. Đặt hàng.");
            System.out.println("2. Xóa giỏ hàng.");
            System.out.println("3. Tiếp tục mua sắm.");
            int choiceOrder = Integer.parseInt(scanner.nextLine());
            switch (choiceOrder) {
                case 1:
                    Order order = orderManage.creatOrder(customer);
                    orderManage.order(order);
                    orderManage.setOrderProducts(new ArrayList<>());
                    System.out.println("1. Thanh toán.");
                    System.out.println("2. Thanh toán sau.");
                    int choicePay = Integer.parseInt(scanner.nextLine());
                    if (choicePay == 1) {
                        for (Order orderInList : OrderManage.orderArrayList) {
                            if ((order.getID() == orderInList.getID())) {
                                orderManage.pay(orderInList);
                            }
                        }
                    } else {
                        System.out.println("Đơn hàng của bạn sẽ bị hủy sau 30s nếu không thanh toán!");
                        order.start();
                    }
                    break;
                case 2:
                    orderManage.setOrderProducts(new ArrayList<>());
                    System.out.println("Đã xóa giỏ hàng.");
                    break;
                case 3:
                    break;
            }
        }
    }

    public void checkOrder(Customer customer) {
        ArrayList<Order> orders = orderManage.searchOrderOfCustomerByID(customer.getId());
        for (Order order : orders) {
            orderManage.displayOrder(order);
        }
        for (Order order : orders) {
            if (order.getStatus().equals("Chưa thanh toán!")) {
                System.out.println("Đơn hàng " + order.getID() + " của bạn chưa được thanh toán.");
                System.out.println("Bạn có muốn thanh toán không: ");
                System.out.println("1. Có.");
                System.out.println("2. Không.");
                System.out.println("3. Hủy đơn.");
                int choicePayOrder = Integer.parseInt(scanner.nextLine());
                if (choicePayOrder == 1) {
                    orderManage.pay(order);
                } else if (choicePayOrder == 3) {
                    orderManage.delete(order);
                }
            }
        }
    }
}

