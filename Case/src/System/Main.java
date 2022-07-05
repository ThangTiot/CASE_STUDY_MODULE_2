package System;

import Manager.CustomerManage;
import Object.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerManage customerManage = new CustomerManage();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Xem");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    customerManage.add(customerManage.creat());
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Nhap id muon xoa");
                    int id = Integer.parseInt(scanner.nextLine());
                    Customer customer = customerManage.searchByID(id);
                    customerManage.delete(customer);
                    break;
                case 4:
                    customerManage.displayAll();
            }
        } while (choice != 0);
    }
}
