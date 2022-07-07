package Manager;

import Object.*;
import System.CRUD;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class OrderManage implements CRUD<Order> {
    static String path = "E:\\CODE_GYM\\MODULE 2\\CASE_STUDY\\Case\\src\\Data\\Order.txt";
    static ReadAndWrite<Order> readAndWriteOrder = new ReadAndWrite<>();
    public static ArrayList<Order> orderArrayList = readAndWriteOrder.read(path);
    ArrayList<Product> orderProducts;
    Scanner scanner;
    ProductManage productManage;

    public OrderManage() {
        if (orderArrayList.size() != 0) {
            Order.ID_ORDER = orderArrayList.get(orderArrayList.size() - 1).getId() + 1;
        }
        scanner = new Scanner(System.in);
        orderProducts = new ArrayList<>();
        productManage = new ProductManage();
    }

    @Override
    public Order creat() {

        return null;
    }

    public Order creatOrder(Customer customer) {
        int totalPrice = totalPrice();
        Order order = new Order(customer, orderProducts, totalPrice);
        return order;
    }


    @Override
    public void add(Order order) {
        orderArrayList.add(order);
        readAndWriteOrder.write(path, orderArrayList);
    }

    @Override
    public void displayAll() {
        for (Order order : orderArrayList) {
            System.out.println(order);
        }
    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(Order order) {
        System.out.println("Bạn có muốn hủy đơn hàng này không?");
        System.out.println("1. Có");
        System.out.println("2. Không");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            orderArrayList.remove(order);
            System.out.println("Hủy đơn hàng thành công!");
        }
    }

    @Override
    public Order searchByID(int id) {
        for (Order order : orderArrayList) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
    public Product checkProductInCart(String id) {
        for (Product product : orderProducts) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void addToCart(Product product, int amount) {
        Product orderProduct = product.clone();
        orderProduct.setAmount(amount);
        orderProducts.add(orderProduct);
        System.out.println("Đã thêm sản phẩm vào giỏ hàng.");
        System.out.println("Đến giỏ hàng để tiến hành thanh toán.");
    }

    public void pay(Order order) {
        for (Product product : order.getProducts()) {
            Product productStorage = productManage.searchByID(product.getId());
            productStorage.setAmount(productStorage.getAmount() - product.getAmount());
        }
        ProductManage.readAndWriteProduct.write(ProductManage.path, ProductManage.productArrayList);
        order.setStatus("Đã thanh toán.");
        System.out.println("Thanh toán thành công!");
        System.out.println("Cảm ơn bạn nha! Yêu bạn!");
        readAndWriteOrder.write(path, orderArrayList);
    }

    public void order(Order order) {
        add(order);
        System.out.println("Đặt hàng thành công!");
        System.out.println("Hãy thanh toán trước khi đơn hàng tự hủy.");
    }

    public int totalPrice() {
        int total = 0;
        for (Product product : orderProducts) {
            int productTotalPrice = product.getPrice() * product.getAmount();
            total += productTotalPrice;
        }
        return total;
    }
    public String changeBalanceTotalPrice(){
        int a = totalPrice();
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String accountBalance = numberFormat.format(a);
        return accountBalance;
    }

    public void displayCart() {
        for (Product product : orderProducts) {
            System.out.println(product);
        }
        System.out.println("Tổng tiền: " + changeBalanceTotalPrice());
    }

    public void displayOrderByID(Order order) {
        System.out.println(order);
    }

    public void displayOrder(Order order) {
        System.out.println("Mã đơn hàng: " + order.getId());
        for (Product product : order.getProducts()) {
            System.out.println("    " + product);
        }
        System.out.println("    Tổng đơn: " + order.changeBalanceOrder());
        System.out.println("    Tình trạng đơn hàng: " + order.getStatus());
    }
    public ArrayList<Order> searchOrderOfCustomerByID(int id) {
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : orderArrayList) {
            if (order.getCustomer().getId() == id) {
                orders.add(order);
            }
        }
        return orders;
    }

    public ArrayList<Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(ArrayList<Product> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
