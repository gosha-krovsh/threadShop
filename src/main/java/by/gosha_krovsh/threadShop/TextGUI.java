package by.gosha_krovsh.threadShop;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TextGUI extends JFrame {
    TextGUI() {
        super("");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(700, 300));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(false);

        configureScreen();
    }

    public void addText(String text) {
        String currentText = textArea.getText();
        textArea.setText(currentText + "\n" + text);
    }

    public void clearText() {
        textArea.setText("");
    }

    private void configureScreen() {
        panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Output"));

        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel.add(scroll);
        add(panel);
    }

    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea(16, 58);
}
