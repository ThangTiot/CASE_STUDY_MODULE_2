package System;

import Manager.AccountManage;

public class Main {
    public static void main(String[] args) {
        AccountManage accountManage = new AccountManage();
        accountManage.creat();
        accountManage.displayAll();
        accountManage.creat();
        accountManage.displayAll();
    }
}
