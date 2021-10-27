package by.gosha_krovsh.threadShop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShopGUI extends JFrame {
    public ShopGUI(String name) {
        super(name);
        this.setMinimumSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUI();
        setButtons();
    }

    public synchronized void Out(String output, boolean await) {
        textGUI.addText(output);
        if (await) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setUI() {
        textGUI.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 1));

        container.add(customerLabel);
        container.add(nameLabel);
        container.add(nameField);
        container.add(moneyLabel);
        container.add(moneyField);
        container.add(addCustomer);
        container.add(startButton);
    }

    private void setButtons() {
        this.startButton.addActionListener(event -> {
            for (var customer : customers) {
                customer.chooseProducts();
                customer.start();
            }
        });
        this.addCustomer.addActionListener(event -> {
            Customer customer = new Customer(nameField.getText(),
                                            Double.parseDouble(moneyField.getText()),
                                            cashBox,
                                            this::Out);
            textGUI.addText(nameField.getText() + " entered the shop" + "\n");
            customers.add(customer);
        });
    }

    CashBox cashBox = new CashBox(List.of(
                    new Cashier("Angel"),
                    new Cashier("Adam"),
                    new Cashier("Amanda")));
    List<Customer> customers = new ArrayList<>();

    private final TextGUI textGUI = new TextGUI();
    private final JLabel customerLabel = new JLabel("Provide Name and Money");
    private final JLabel nameLabel = new JLabel("Name: ");
    private final JTextField nameField = new JTextField("", 10);
    private final JLabel moneyLabel = new JLabel("Money: ");
    private final JTextField moneyField = new JTextField("", 10);
    private final JButton addCustomer = new JButton("Add Customer");
    private final JButton startButton = new JButton("Start");
}
