package by.gosha_krovsh.threadShop;

public class Customer extends Thread {
    public Customer(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " entered the supermarket");

        double money = (int) (Math.random() * 30 + 10);
        ShopingBasket basket = new ShopingBasket();
        int randombuy = (int) (Math.random() * 8 + 1);
        for (int i = 0; i < randombuy; i++) {
            Good good = Shelf.getRandomGood();
            basket.put(new Item(good, basket.getItemsList().size() + 1, 1));
            System.out.println(name + " put a " + good.getName() + " into his Basket");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CashBox.buy(basket, money, name);
    }

    private String name;
}