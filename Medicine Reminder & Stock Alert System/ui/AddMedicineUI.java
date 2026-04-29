package ui;

import connection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddMedicineUI extends JFrame {

    public AddMedicineUI() {
        setTitle("Add Medicine");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField qtyField = new JTextField();
        JTextField expiryField = new JTextField();

        JButton addBtn = new JButton("Add");

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("Quantity:"));
        add(qtyField);

        add(new JLabel("Expiry (YYYY-MM-DD):"));
        add(expiryField);

        add(new JLabel());
        add(addBtn);

        addBtn.addActionListener(e -> {
            try {
                Connection con = DBConnection.getConnection();

                String sql = "INSERT INTO medicines (medicine_name, quantity, expiry_date) VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, nameField.getText());
                ps.setInt(2, Integer.parseInt(qtyField.getText()));
                ps.setString(3, expiryField.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "✅ Medicine Added!");

                nameField.setText("");
                qtyField.setText("");
                expiryField.setText("");

                con.close();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        setVisible(true);
    }
}