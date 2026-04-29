package ui;

import javax.swing.*;
import java.awt.*;

public class MainMenuUI extends JFrame {

    public MainMenuUI() {
        setTitle("Medicine Reminder System");
        setSize(400, 300);
        setLayout(new GridLayout(4, 1));

        JButton addBtn = new JButton("Add Medicine");
        JButton viewBtn = new JButton("View Medicines");
        JButton stockBtn = new JButton("Stock Alert");
        JButton exitBtn = new JButton("Exit");

        add(addBtn);
        add(viewBtn);
        add(stockBtn);
        add(exitBtn);

        addBtn.addActionListener(e -> new AddMedicineUI());
        viewBtn.addActionListener(e -> new ViewMedicineUI());
        stockBtn.addActionListener(e -> new StockAlertUI());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}