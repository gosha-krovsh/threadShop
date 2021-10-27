package by.gosha_krovsh.threadShop;

import java.util.ArrayList;

public class ShopingBasket {
    private final ArrayList<Item> itemsList = new ArrayList<>();

    protected void put(Item item) {
        if (itemsList.contains(item)) {
            item.setQuantity(item.getQuantity() + 1);
        } else {
            itemsList.add(item);
        }
    }

    protected boolean isEmpty() {
        return itemsList.isEmpty();
    }

    protected void leave(Item item) {
        itemsList.remove(item);
    }

    protected ArrayList<Item> getItemsList() {
        return itemsList;
    }
}
