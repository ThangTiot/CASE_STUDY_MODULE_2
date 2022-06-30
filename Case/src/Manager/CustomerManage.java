package Manager;

import Object.Customer;
import Verified.Verified;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerManage{
    Scanner scanner;
    Verified verified;

    public CustomerManage() {
        scanner = new Scanner(System.in);
        verified = new Verified();
    }

    public Customer create() {
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
        boolean check = verified.VerifiedPhoneNumber(phoneNumber);
        while (!check) {
            System.out.println("Incorrect telephone number! \n Retype: ");
            phoneNumber = scanner.nextLine();
            check = verified.VerifiedPhoneNumber(phoneNumber);
        }
        Customer customer = new Customer(name,age,gender,phoneNumber);
        return customer;
    }


    public void update(Customer customer) {
        customer = create();
    }
}
