package by.gosha_krovsh.threadShop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Receipt {
    public Receipt(int id,
                   ArrayList<Item> itemsList,
                   LocalDateTime ldt,
                   double totalSum,
                   double change,
                   String customerName) {
        this.id = id;
        this.itemsList = itemsList;
        this.ldt = ldt;
        this.totalSum = totalSum;
        this.change = change;
        out();
    }

    private synchronized void out() {
        System.out.println("ID " + id);
        System.out.println(ldt.format(formatter));
        for (int i = 0; i < itemsList.size(); i++) {
            Item item = itemsList.get(i);
            System.out.println("Number : " + item.getNumber() +
                    " Quantity " + item.getQuantity() + " " + item.getGood().getName() +
                    " Price " + Math.round(item.getCost() * 100.0) / 100.0 + " Discount : " +
                    Math.round(item.getDiscountAmount() * 100.0) / 100.0);
        }
        System.out.println("Sum " + Math.round(totalSum * 100.0) / 100.0);
        System.out.println("Change " + Math.round(change * 100.0) / 100.0);
    }

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
    private final int id;
    private final ArrayList<Item> itemsList;
    private final LocalDateTime ldt;
    private final double totalSum;
    private final double change;
}
