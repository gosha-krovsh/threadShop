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
        String result = ldt.format(formatter) + "\n";
        result += customerName + "\n";
        for (Item item : itemsList) {
            result += "Number : " + item.getNumber() +
                    " Quantity " + item.getQuantity() + " " + item.getGood().getName() +
                    " Price " + Math.round(item.getCost() * 100.0) / 100.0 + " Discount : " +
                    Math.round(item.getDiscountAmount() * 100.0) / 100.0 + "\n";
        }
        result += "Sum " + Math.round(totalSum * 100.0) / 100.0 + "\n";
        result += "Change " + Math.round(change * 100.0) / 100.0 + "\n";
        System.out.println(result);

        return result;
    }

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
    private final ArrayList<Item> itemsList;
    private final LocalDateTime ldt;
    private final double totalSum;
    private final double change;
    private final String customerName;
}
