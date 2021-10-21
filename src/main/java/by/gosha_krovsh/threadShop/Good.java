package by.gosha_krovsh.threadShop;

import lombok.Data;

@Data
public class Good {
    public Good(int id, String name, double price, int discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    private int id;
    private String name;
    private double price;
    private int discount;
}
