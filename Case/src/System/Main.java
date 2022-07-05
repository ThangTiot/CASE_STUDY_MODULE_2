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
            System.out.println("*-*-*-*-*-*-* BÁCH HÓA VÔ DỤNG XIN CHÀO *-*-*-*-*-*-*");
            System.out.println("1. Đăng nhập.");
            System.out.println("2. Đăng kí.");
            System.out.println("3. Thoát.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean check = true;
                    do {
                        System.out.println("User Name: ");
                        String userName = scanner.nextLine();
                        System.out.println("Password: ");
                        String password = scanner.nextLine();
                        if (userName.equals("Admin") && password.equals("admin")) {
                            menuManage.menuAdmin();
                        } else {
                            customer = signIn.signIn(userName, password);
                            if (customer != null) {
                                menuManage.menuCustomer();
                            } else {
                                check = false;
                                System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
                                System.out.println("Thử lại!");
                            }
                        }
                    } while (!check);
                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    customerManage.displayAll();
            }
        } while (choice != 0);
    }
}
