package Object;

import java.util.ArrayList;

public class Order {
    private Account account;
    private ArrayList<Product> products;
    private String status = "Chưa thanh toán";

    public Order() {
    }

    public Order(Account account, ArrayList<Product> products) {
        this.account = account;
        this.products = products;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
