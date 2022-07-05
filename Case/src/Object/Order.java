package Object;

import java.util.ArrayList;

public class Order {
    public static int ID_ORDER = 1;
    private int id;
    private Customer customer;
    private Product product;
    private String status = "Chưa thanh toán!";

    public Order() {
    }

    public Order(Customer customer, Product product) {
        this.id = ID_ORDER++;
        this.customer = customer;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", product=" + product +
                ", status='" + status + '\'' +
                '}';
    }
}
