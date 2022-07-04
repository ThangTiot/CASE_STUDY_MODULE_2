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
        System.out.println("Full name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Gender: ");
        System.out.println("1. Male.");
        System.out.println("2. Female.");
        System.out.println("3. Other.");
        int choice = Integer.parseInt(scanner.nextLine());
        String gender = "";
        switch (choice) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Other";
                break;
        }
        System.out.println("Phone Number:");
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
//        customerArrayList = readAndWriteCustomer.read(path);
        for (Customer customer : customerArrayList) {
            System.out.println(customer);
        }
    }

    @Override
    public void update(Customer customer) {
        System.out.println("Full name: ");
        String name = scanner.nextLine();
        System.out.println("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Gender: ");
        System.out.println("1. Male.");
        System.out.println("2. Female.");
        System.out.println("3. Other.");
        int choice = Integer.parseInt(scanner.nextLine());
        String gender = "";
        switch (choice) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Other";
                break;
        }
        System.out.println("Phone Number:");
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
    public void delete(Customer customer) {
        System.out.println("Bạn có muốn xóa không?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            customerArrayList.remove(customer);
            System.out.println("Xóa thành công!");
        }
    }
}
