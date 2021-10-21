package by.gosha_krovsh.threadShop;

public class ShopDemo {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Customer customer3 = new Customer("Customer 3");
        Customer customer4 = new Customer("Customer 4");
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
    }
}
