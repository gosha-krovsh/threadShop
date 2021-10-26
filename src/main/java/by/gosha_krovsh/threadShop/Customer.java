package by.gosha_krovsh.threadShop;

import java.util.List;

public class Customer extends Thread {
    public Customer(String name, double money, CashBox cashBox) {
        super();
        this.name = name;
        this.basket = new ShopingBasket();
        this.money = money;
        this.cashBox = cashBox;
    }

    @Override
    public void run() {
        System.out.println(name + " entered the supermarket");
        if (basket.isEmpty()) {
            chooseProducts();
//             Test version
//             throw new RuntimeException("Badly created Customer");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Cashier cashier = cashBox.getCashier();
        Receipt receipt = cashier.process(this.basket, this.money, this.name);
        receipt.out();
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

    private final ShopingBasket basket;
    private final CashBox cashBox;
    private final String name;
    private final double money;
}