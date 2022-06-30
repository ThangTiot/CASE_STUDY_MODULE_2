package Manager;
import System.CRUD;
import Object.Account;
import Verified.Verified;
import Manager.CustomerManage;
import Object.*;

import java.util.ArrayList;
import java.util.Scanner;


public class AccountManage implements CRUD<Account> {
    Scanner scanner;
    ReadAndWrite<Account> readAndWrite;
    Verified verifier;
    CustomerManage customerManage;
    ArrayList<Account> accountArrayList;

    public AccountManage() {
        scanner = new Scanner(System.in);
        readAndWrite = new ReadAndWrite<>();
        verifier = new Verified();
        customerManage = new CustomerManage();
        accountArrayList = readAndWrite.read("E:\\CODE_GYM\\MODULE 2\\CASE_STUDY\\Case\\src\\Data\\Account.txt");
    }

    @Override
    public Account creat() {
        System.out.println("UserName:");
        String userName = scanner.nextLine();
        while (checkUserName(userName) != null) {
            System.out.println("Tên đã tồn tại!\n Nhập tên khác: ");
            userName = scanner.nextLine();
        }
        System.out.println("Password:\n Chú ý: Tối thiểu 8 kí tự chữ hoặc số, bắt đầu bằng kí tự viết hoa.");
        String password = scanner.nextLine();
        boolean check = verifier.VerifiedPassword(password);
        while (!check) {
            System.out.println("Password không hợp lệ! \n Nhập lại password: ");
            password = scanner.nextLine();
            check = verifier.VerifiedPassword(password);
        }
        Customer customer = customerManage.create();
        Account account = new Account(userName, password, customer);
        return account;
    }

    @Override
    public void add(Account account) {
        accountArrayList.add(account);
    }

    @Override
    public void displayAll() {
        for (Account account : accountArrayList) {
            System.out.println(account);
        }
    }

    @Override
    public void update(Account account) {
        System.out.println("UserName:");
        String userName = scanner.nextLine();
        while (checkUserName(userName) != null) {
            System.out.println("Tên đã tồn tại!\n Nhập tên khác: ");
            userName = scanner.nextLine();
        }
        System.out.println("Password:\n Chú ý: Tối thiểu 8 kí tự chữ hoặc số, bắt đầu bằng kí tự viết hoa.");
        String password = scanner.nextLine();
        boolean check = verifier.VerifiedPassword(password);
        while (!check) {
            System.out.println("Password không hợp lệ! \n Nhập lại password: ");
            password = scanner.nextLine();
            check = verifier.VerifiedPassword(password);
        }
        account.setUsername(userName);
        account.setPassword(password);
    }

    @Override
    public void delete(Account account) {
        accountArrayList.remove(account);
    }
    public Account checkUserName(String userName){
        try {
            ArrayList<Account> accountArrayList = readAndWrite.read("E:\\CODE_GYM\\MODULE 2\\CASE_STUDY\\Case\\src\\Data\\Account.txt");
            for (Account account : accountArrayList) {
                if (account.getUsername().equals(userName)) {
                    return account;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
