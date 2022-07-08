package Object;

import Manager.OrderManage;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class Order extends Thread implements Serializable {
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

    public int getID() {
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

    public String changeBalanceOrder() {
        int a = totalPrice;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String accountBalance = numberFormat.format(a);
        return accountBalance;
    }

    public String displayProducts() {
        String s = "         ";
        for (int i = 0; i < products.size(); i++) {
            if (i == (products.size() - 1)) {
                s += products.get(i);
            } else {
                s += (products.get(i) + "\n         ");
            }
        }
        return s;
    }

    @Override
    public void run() {
        try {
            sleep(30000);
            if (this.status.equals("Chưa thanh toán!")) {
                for (Order orderInList : OrderManage.orderArrayList) {
                    if ((this.id == orderInList.getID())) {
                        OrderManage.orderArrayList.remove(orderInList);
                        System.out.println("Đơn hàng của bạn đã bị hủy do quá thời hạn thanh toán!");
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "* Mã đơn hàng: " + id +
                "\n    " + customer +
                "\n    - Đơn hàng: \n" + displayProducts() +
                "\n    - Tổng đơn: " + changeBalanceOrder() +
                "/ Trạng thái đơn hàng: '" + status + '\'';
    }
}
