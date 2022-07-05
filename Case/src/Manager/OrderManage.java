package Manager;

import Object.Order;
import System.CRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManage implements CRUD<Order> {
    static String path = "E:\\CODE_GYM\\MODULE 2\\CASE_STUDY\\Case\\src\\Data\\Order.txt";
    static ReadAndWrite<Order> readAndWriteOrder = new ReadAndWrite<>();
    static ArrayList<Order> orderArrayList = readAndWriteOrder.read(path);
    Scanner scanner;

    public OrderManage() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Order creat() {
        return null;
    }

    @Override
    public void add(Order order) {
        orderArrayList.add(order);
        readAndWriteOrder.write(path,orderArrayList);
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
            System.out.println("Xóa khách hàng thành công!");
        }
    }

    @Override
    public Order searchByID(int id) {
        return null;
    }
}
