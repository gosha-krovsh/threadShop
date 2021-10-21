package by.gosha_krovsh.threadShop;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopingBasket {
    ArrayList<Item> itemsList = new ArrayList<>();

    protected void put(Item item) {
        if (itemsList.contains(item)) {
            item.setQuantity(item.getQuantity() + 1);
        } else {
            itemsList.add(item);
        }
    }

    protected void leave(Item item) {
        itemsList.remove(item);
    }

    protected ArrayList<Item> getItemsList() {
        return itemsList;
    }
}
