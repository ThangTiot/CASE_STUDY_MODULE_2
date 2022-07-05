package Manager;

import Object.Customer;
import Verified.Verified;
import System.CRUD;
import Object.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManage implements CRUD<Customer>{
    Scanner scanner;
    Verified verified;
    AccountManage accountManage;
    static String path = "E:\\CODE_GYM\\MODULE 2\\CASE_STUDY\\Case\\src\\Data\\Customer.txt";
    static ReadAndWrite<Customer> readAndWriteCustomer = new ReadAndWrite<>();
    static ArrayList<Customer> customerArrayList = readAndWriteCustomer.read(path);

    public CustomerManage() {
        scanner = new Scanner(System.in);
        verified = new Verified();
        accountManage = new AccountManage();
    }

    @Override
    public Customer creat() {
        if (customerArrayList.size() != 0) {
            Customer.ID_CUSTOMER = customerArrayList.get((customerArrayList.size() - 1)).getId() + 1;
        }
        System.out.println("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Giới tính: ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Khác");
        int choice = Integer.parseInt(scanner.nextLine());
        String gender = "";
        switch (choice) {
            case 1:
                gender = "Nam";
                break;
            case 2:
                gender = "Nữ";
                break;
            case 3:
                gender = "Khác";
                break;
        }
        System.out.println("Số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        boolean check = verified.verifiedPhoneNumber(phoneNumber);
        while (!check) {
            System.out.println("Sai số điện thoại! \n Nhập lại: ");
            phoneNumber = scanner.nextLine();
            check = verified.verifiedPhoneNumber(phoneNumber);
        }
        Account account = accountManage.creat();
        Customer customer = new Customer(name,age,gender,phoneNumber,account);
        return customer;
    }

    @Override
    public void add(Customer customer) {
        customerArrayList.add(customer);
        readAndWriteCustomer.write(path,customerArrayList);
    }

    @Override
    public void displayAll() {
        for (Customer customer : customerArrayList) {
            System.out.println(customer);
        }
    }

    public void update(Customer customer) {
        System.out.println("Họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Giới tính: ");
        System.out.println("1. Nam");
        System.out.println("2. Nữ");
        System.out.println("3. Khác");
        int choice = Integer.parseInt(scanner.nextLine());
        String gender = "";
        switch (choice) {
            case 1:
                gender = "Nam";
                break;
            case 2:
                gender = "Nữ";
                break;
            case 3:
                gender = "Khác";
                break;
        }
        System.out.println("Số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        boolean check = verified.verifiedPhoneNumber(phoneNumber);
        while (!check) {
            System.out.println("Sai số điện thoại! \n Nhập lại: ");
            phoneNumber = scanner.nextLine();
            check = verified.verifiedPhoneNumber(phoneNumber);
        }
        customer.setName(name);
        customer.setAge(age);
        customer.setGender(gender);
        customer.setPhoneNumber(phoneNumber);
    }

    @Override
    public Customer searchByID(int id) {
        for (Customer customer : customerArrayList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public void delete(Customer customer) {
        System.out.println("Bạn có muốn xóa khách hàng này không?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            customerArrayList.remove(customer);
            System.out.println("Xóa khách hàng thành công!");
        }
        readAndWriteCustomer.write(path,customerArrayList);
    }
}
