package Object;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    public static int ID_ORDER = 1;
    private int id;
    private Customer customer;
    private ArrayList<Product> products;
    private int totalPrice;
    private String status = "Chưa thanh toán!";

    public Order() {
    }

    public Order(Customer customer, ArrayList<Product> products, int totalPrice) {
        this.id = ID_ORDER++;
        this.customer = customer;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> product) {
        this.products = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return  "Mã đơn hàng: " + id +
                "\n    " + customer +
                "\n    Đơn hàng: \n     " + products +
                "\n    Tổng đơn: " + totalPrice + " VND" +
                ", Trạng thái đơn hàng: '" + status + '\'' +
                '}';
    }
}
