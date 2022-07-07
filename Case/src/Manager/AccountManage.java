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
        System.out.println("Tên đăng nhập:");
        String userName = scanner.nextLine();
        while (checkUserName(userName) != null) {
            System.out.println("Tên đã tồn tại!\n Nhập tên khác: ");
            userName = scanner.nextLine();
        }
        System.out.println("Mật khẩu:\n Chú ý: Tối thiểu 8 kí tự chữ hoặc số, bắt đầu bằng kí tự viết hoa.");
        String password = scanner.nextLine();
        boolean check = verifier.verifiedPassword(password);
        while (!check) {
            System.out.println("Mật khẩu không hợp lệ! \n Nhập lại mật khẩu: ");
            password = scanner.nextLine();
            check = verifier.verifiedPassword(password);
        }
        Account account = new Account(userName, password);
        return account;
    }


    public void update(Account account) {
        System.out.println("Tên đăng nhập mới:");
        String userName = scanner.nextLine();
        while (checkUserName(userName) != null) {
            System.out.println("Tên đã tồn tại!\n Nhập tên khác: ");
            userName = scanner.nextLine();
        }
        System.out.println("Mật khẩu mới:\n Chú ý: Tối thiểu 8 kí tự chữ hoặc số, bắt đầu bằng kí tự viết hoa.");
        String password = scanner.nextLine();
        boolean check = verifier.verifiedPassword(password);
        while (!check) {
            System.out.println("Mật khẩu không hợp lệ! \n Nhập lại mật khẩu: ");
            password = scanner.nextLine();
            check = verifier.verifiedPassword(password);
        }
        account.setUsername(userName);
        account.setPassword(password);
        System.out.println("Thay đổi đã được ghi nhận!");
        CustomerManage.readAndWriteCustomer.write(CustomerManage.path,CustomerManage.customerArrayList);
    }

    public Customer checkUserName(String userName){
            for (Customer customer : CustomerManage.customerArrayList) {
                if (customer.getAccount().getUsername().equals(userName)) {
                    return customer;
                }
            }
        return null;
    }
}
