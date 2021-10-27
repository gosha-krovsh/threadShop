package by.gosha_krovsh.threadShop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Cashier {
    public Cashier(String name) {
        this.name = name;
    }

    public synchronized Receipt process(ShopingBasket basket, Double money, String name) {
        ArrayList<Item> itemsList = basket.getItemsList();
        try {
            Thread.sleep(10 * itemsList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Optional<Double> maxPrice = itemsList.stream().map(Item::getCost).reduce(Double::sum);
        if (maxPrice.isPresent() && money >= maxPrice.get()) {
            double change = money - maxPrice.get();
            return new SuccessReceipt(itemsList, LocalDateTime.now(), maxPrice.get(), change, name, this.name);
        } else {
            return new FailureReceipt("Not Enough Money", LocalDateTime.now(), name, this.name);
        }
    }

    private final String name;
}
