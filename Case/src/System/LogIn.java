package System;
import Manager.AccountManage;
import Object.Customer;

public class LogIn {
    AccountManage accountManage;

    public LogIn() {
        accountManage = new AccountManage();
    }

    public Customer login(String userName, String password) {
        Customer customer = accountManage.checkUserName(userName);
        if (customer != null && customer.getAccount().getUsername().equals(userName)) {
            if (customer.getAccount().getPassword().equals(password)) {
                return customer;
            } else {
                return null;
            }
        }
        return customer;
    }
}
