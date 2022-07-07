package Object;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Product implements Comparable<Product>, Serializable, Cloneable {
    private String id;
    private String name;
    private int price;
    private int amount;

    public Product() {
    }

    public Product(String id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int compareTo(Product product) {
        return this.price - product.getPrice();
    }
    public Product clone(){
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
    public String changeBalanceProduct(){
        int a = price;
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String accountBalance = numberFormat.format(a);
        return accountBalance;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID: " + id +
                ", Tên: '" + name + '\'' +
                ", Giá: " + changeBalanceProduct() +
                ", Số lượng: " + amount +
                '}';
    }
}
