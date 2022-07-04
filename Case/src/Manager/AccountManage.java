package Manager;
import System.CRUD;
import Object.Account;
import Verified.Verified;
import Object.*;

import java.util.Scanner;


public class AccountManage{
    Scanner scanner;
    Verified verifier;

    public AccountManage() {
        scanner = new Scanner(System.in);
        verifier = new Verified();
    }

    public Account creat() {
        System.out.println("UserName:");
        String userName = scanner.nextLine();
        while (checkUserName(userName) != null) {
            System.out.println("Tên đã tồn tại!\n Nhập tên khác: ");
            userName = scanner.nextLine();
        }
        System.out.println("Password:\n Chú ý: Tối thiểu 8 kí tự chữ hoặc số, bắt đầu bằng kí tự viết hoa.");
        String password = scanner.nextLine();
        boolean check = verifier.verifiedPassword(password);
        while (!check) {
            System.out.println("Password không hợp lệ! \n Nhập lại password: ");
            password = scanner.nextLine();
            check = verifier.verifiedPassword(password);
        }
        Account account = new Account(userName, password);
        return account;
    }


    public void update(Account account) {
        System.out.println("UserName:");
        String userName = scanner.nextLine();
        while (checkUserName(userName) != null) {
            System.out.println("Tên đã tồn tại!\n Nhập tên khác: ");
            userName = scanner.nextLine();
        }
        System.out.println("Password:\n Chú ý: Tối thiểu 8 kí tự chữ hoặc số, bắt đầu bằng kí tự viết hoa.");
        String password = scanner.nextLine();
        boolean check = verifier.verifiedPassword(password);
        while (!check) {
            System.out.println("Password không hợp lệ! \n Nhập lại password: ");
            password = scanner.nextLine();
            check = verifier.verifiedPassword(password);
        }
        account.setUsername(userName);
        account.setPassword(password);
    }

    public Customer checkUserName(String userName){
        try {
            for (Customer customer : CustomerManage.customerArrayList) {
                if (customer.getAccount().getUsername().equals(userName)) {
                    return customer;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
