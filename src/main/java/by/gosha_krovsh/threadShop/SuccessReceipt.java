package by.gosha_krovsh.threadShop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SuccessReceipt implements Receipt {
    public SuccessReceipt(ArrayList<Item> itemsList,
                          LocalDateTime ldt,
                          double totalSum,
                          double change,
                          String customerName) {
        this.itemsList = itemsList;
        this.ldt = ldt;
        this.totalSum = totalSum;
        this.change = change;
        this.customerName = customerName;
    }

    public String out() {
        StringBuilder result = new StringBuilder(ldt.format(formatter) + "\n");
        result.append(customerName).append("\n");
        for (Item item : itemsList) {
            result.append("Number : ")
                    .append(item.getNumber())
                    .append(" Quantity ")
                    .append(item.getQuantity())
                    .append(" ")
                    .append(item.getGood().getName())
                    .append(" Price ")
                    .append(Math.round(item.getCost() * 100.0) / 100.0)
                    .append(" Discount : ")
                    .append(Math.round(item.getDiscountAmount() * 100.0) / 100.0)
                    .append("\n");
        }
        result.append("Sum ")
                .append(Math.round(totalSum * 100.0) / 100.0)
                .append("\n");
        result.append("Change ")
                .append(Math.round(change * 100.0) / 100.0)
                .append("\n");
        System.out.println(result);

        return result.toString();
    }

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
    private final ArrayList<Item> itemsList;
    private final LocalDateTime ldt;
    private final double totalSum;
    private final double change;
    private final String customerName;
}
