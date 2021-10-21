package by.gosha_krovsh.threadShop;

import java.time.LocalDateTime;
import java.util.ArrayList;

public final class CashBox {
    private static double maxPrice = 0;
    private static double change = 0;
    private static int id;

    protected static void buy(ShopingBasket basket, Double money, String name) {
        int chashieNumber = (int) (Math.random() * 3 + 0);
        switch (chashieNumber) {
            case 1:
                cashier_1(basket, money, name);
                break;
            case 2:
                cashier_2(basket, money, name);
                break;
            case 3:
                cashier_3(basket, money, name);
                break;
            default:
                cashier_1(basket, money, name);
                break;
        }
    }

    // This looks kinda weird, but thar was made for a purpose. :)
    protected static synchronized void cashier_1(ShopingBasket basket, Double money, String name) {
        ArrayList<Item> itemsList = basket.getItemsList();
        try {
            Thread.sleep(10 * itemsList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < itemsList.size(); i++) {
            maxPrice += itemsList.get(i).getCost();
        }
        if (money >= maxPrice) {
            id++;
            change = money - maxPrice;
            new Receipt(id, itemsList, LocalDateTime.now(), maxPrice, change, name);
        } else {
            id++;
            System.out.println("ID " + id);
            System.out.println(name);
            System.out.println("Not Enough Money");
        }
    }

    protected static synchronized void cashier_2(ShopingBasket basket, Double money, String name) {
        ArrayList<Item> itemsList = basket.getItemsList();
        try {
            Thread.sleep(10 * itemsList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < itemsList.size(); i++) {
            maxPrice += itemsList.get(i).getCost();
        }
        if (money >= maxPrice) {
            id++;
            change = money - maxPrice;
            new Receipt(id, itemsList, LocalDateTime.now(), maxPrice, change, name);
        } else {
            id++;
            System.out.println("ID " + id);
            System.out.println(name);
            System.out.println("Not Enough Money");
        }
    }

    protected static synchronized void cashier_3(ShopingBasket basket, Double money, String name) {
        ArrayList<Item> itemsList = basket.getItemsList();
        try {
            Thread.sleep(10 * itemsList.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < itemsList.size(); i++) {
            maxPrice += itemsList.get(i).getCost();
        }
        if (money >= maxPrice) {
            id++;
            change = money - maxPrice;
            new Receipt(id, itemsList, LocalDateTime.now(), maxPrice, change, name);
        } else {
            id++;
            System.out.println("ID " + id);
            System.out.println(name);
            System.out.println("Not Enough Money");
        }
    }
}
