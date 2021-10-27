package by.gosha_krovsh.threadShop;

import java.util.List;

public class CashBox {
    CashBox(List<Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    protected Cashier getCashier() {
        int chashieNumber = (int) (Math.random() * 3 + 0);
        switch (chashieNumber) {
            case 2: {
                synchronized (this.cashiers) {
                    return cashiers.get(1);
                }
            }
            case 3: {
                synchronized (this.cashiers) {
                    return cashiers.get(2);
                }
            }
            default: {
                synchronized (this.cashiers) {
                    return cashiers.get(0);
                }
            }
        }
    }

    private final List<Cashier> cashiers;
}
