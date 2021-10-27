package by.gosha_krovsh.threadShop;

import java.util.List;
import java.util.function.BiConsumer;

public class Customer extends Thread {
    public Customer(String name,
                    double money,
                    CashBox cashBox,
                    BiConsumer<String, Boolean> receiptConsumer) {
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
        receiptConsumer.accept(receipt.out(), true);
    }

    public List<Item> chooseProducts() {
        int good_amount = (int) (Math.random() * 8 + 1);
        String print = "";
        for (int i = 0; i < good_amount; i++) {
            Good good = Shelf.getRandomGood();
            this.basket.put(new Item(good, basket.getItemsList().size() + 1, 1));

            print += name + " put a " + good.getName() + " into his Basket" + "\n";
        }
        receiptConsumer.accept(print, false);
        return this.basket.getItemsList();
    }

    private final BiConsumer<String, Boolean> receiptConsumer;
    private final ShopingBasket basket;
    private final CashBox cashBox;
    private final String name;
    private final double money;
}