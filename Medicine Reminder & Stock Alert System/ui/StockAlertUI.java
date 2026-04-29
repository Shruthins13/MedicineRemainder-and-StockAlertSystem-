package ui;

import connection.DBConnection;

import javax.swing.*;
import java.sql.*;

public class StockAlertUI extends JFrame {

    JTextArea area;

    public StockAlertUI() {
        setTitle("Low Stock Alert");
        setSize(400, 300);

        area = new JTextArea();
        add(new JScrollPane(area));

        checkStock();

        setVisible(true);
    }

    void checkStock() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM medicines WHERE quantity <= 5"
            );

            StringBuilder sb = new StringBuilder();

            while (rs.next()) {
                sb.append(rs.getString("medicine_name"))
                  .append(" → Remaining: ")
                  .append(rs.getInt("quantity"))
                  .append("\n");
            }

            if (sb.length() == 0) {
                area.setText("✅ All medicines are in stock");
            } else {
                area.setText("⚠️ LOW STOCK:\n\n" + sb.toString());
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}