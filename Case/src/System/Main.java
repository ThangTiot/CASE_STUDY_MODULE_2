package System;

import Manager.CustomerManage;
import Object.Customer;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        MenuManage menuManage = new MenuManage();
        CustomerManage customerManage = new CustomerManage();
        SignIn signIn = new SignIn();
        Scanner scanner = new Scanner(System.in);
        Customer customer;
        int choice;
        do {
            try {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("*-*-*-*-*-*-* BÁCH HÓA VÔ DỤNG XIN CHÀO *-*-*-*-*-*-*");
                System.out.println("*-*-*-*-THỨ GÌ BẠN CẦN CHÚNG TÔI ĐỀU KHÔNG CÓ *-*-*-*");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("1. Đăng nhập.");
                System.out.println("2. Đăng kí.");
                System.out.println("3. Thoát.");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        boolean check;
                        int count = 0;
                        do {
                            check = true;
                            System.out.println("User Name: ");
                            String userName = scanner.nextLine();
                            System.out.println("Password: ");
                            String password = scanner.nextLine();
                            if (userName.equals("Admin") && password.equals("admin")) {
                                menuManage.menuAdmin();
                            } else {
                                customer = signIn.signIn(userName, password);
                                if (customer != null) {
                                    menuManage.menuCustomer(customer);
                                } else {
                                    check = false;
                                    count++;
                                    System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
                                    System.out.println("Thử lại! Số lần thử còn lại: " + (3 - count));
                                }
                            }
                        } while (!check && count < 3);
                        break;
                    case 2:
                        customer = customerManage.creat();
                        customerManage.add(customer);
                        menuManage.menuCustomer(customer);
                        break;
                    case 3:
                        System.exit(3);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("Lựa chọn không phù hợp!");
                choice = 4;
            }
        } while (choice != 0);
    }
}
