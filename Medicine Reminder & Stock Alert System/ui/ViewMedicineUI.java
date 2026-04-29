package ui;

import connection.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewMedicineUI extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewMedicineUI() {
        setTitle("View Medicines");
        setSize(600, 400);

        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Quantity");
        model.addColumn("Expiry");

        loadData();

        add(new JScrollPane(table));
        setVisible(true);
    }

    void loadData() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM medicines");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("medicine_id"),
                        rs.getString("medicine_name"),
                        rs.getInt("quantity"),
                        rs.getDate("expiry_date")
                });
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}