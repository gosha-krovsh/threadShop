package by.gosha_krovsh.threadShop;

import lombok.Data;

@Data
public class Item {
    private Good good;
    private int number;
    private int quantity;
    private int discount;
    private double discountAmount;
    private double cost;

    public Item(Good good, int number, int quantity) {
        this.good = good;
        this.number = number;
        this.quantity = quantity;
        discount = good.getDiscount();
        discountAmount = (Math.round((discount / 100.) * 100.0) / 100.0) * good.getPrice();
        cost = good.getPrice() - discountAmount;
    }
}
