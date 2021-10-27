package by.gosha_krovsh.threadShop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FailureReceipt implements Receipt {
    FailureReceipt(String cause,
                   LocalDateTime ldt,
                   String customerName,
                   String cashierName) {
        this.cause = cause;
        this.customerName = customerName;
        this.cashierName = cashierName;
        this.ldt = ldt;
    }

    @Override
    public String out() {
        String result = ldt.format(formatter) + "\n";
        result += this.customerName + "\n";
        result += "Cashier: " + cashierName + "\n";
        result += this.cause + "\n";
        System.out.println(result);

        return result;
    }

    private final String cause;
    private final String customerName;
    private final String cashierName;
    private final LocalDateTime ldt;
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
}
