package by.gosha_krovsh.threadShop;

import java.util.List;
import java.util.function.Consumer;

public class Customer extends Thread {
    public Customer(String name,
                    double money,
                    CashBox cashBox,
                    Consumer<String> receiptConsumer) {
        super();
        this.name = name;
        this.basket = new ShopingBasket();
        this.money = money;
        this.cashBox = cashBox;
        this.receiptConsumer = receiptConsumer;
    }

    @Override
    public void run() {
        System.out.println(name + " entered the supermarket");
        if (basket.isEmpty()) {
            chooseProducts();
             throw new RuntimeException("Badly created Customer");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Cashier cashier = cashBox.getCashier();
        Receipt receipt = cashier.process(this.basket, this.money, this.name);
        receiptConsumer.accept(receipt.out());
//        System.out.println(receipt.out());
//        JOptionPane.showMessageDialog(null, receipt.out());
    }

    public List<Item> chooseProducts() {
        int good_amount = (int) (Math.random() * 8 + 1);
        for (int i = 0; i < good_amount; i++) {
            Good good = Shelf.getRandomGood();

            this.basket.put(new Item(good, basket.getItemsList().size() + 1, 1));
            System.out.println(name + " put a " + good.getName() + " into his Basket");
        }
        return this.basket.getItemsList();
    }

    private final Consumer<String> receiptConsumer;
    private final ShopingBasket basket;
    private final CashBox cashBox;
    private final String name;
    private final double money;
}