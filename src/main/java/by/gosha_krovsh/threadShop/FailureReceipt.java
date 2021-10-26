package by.gosha_krovsh.threadShop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FailureReceipt implements Receipt {
    FailureReceipt(String cause,
                   LocalDateTime ldt,
                   String customerName) {
        this.cause = cause;
        this.customerName = customerName;
        this.ldt = ldt;
    }

    @Override
    public synchronized void out() {
        String result = ldt.format(formatter) + "\n";
        result += this.customerName + "\n";
        result += this.cause + "\n";
        System.out.println(result);
    }

    private final String cause;
    private final String customerName;
    private final LocalDateTime ldt;
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
}
