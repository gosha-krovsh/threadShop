package by.gosha_krovsh.threadShop;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CashBox cashBox = new CashBox(List.of(
                new Cashier("Angel"),
                new Cashier("Adam"),
                new Cashier("Amanda")));
        Customer customer1 = new Customer("Customer 1", 10, cashBox);
        Customer customer2 = new Customer("Customer 2", 5, cashBox);
        Customer customer3 = new Customer("Customer 3", 15, cashBox);
        Customer customer4 = new Customer("Customer 4", 25, cashBox);
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
    }
}
