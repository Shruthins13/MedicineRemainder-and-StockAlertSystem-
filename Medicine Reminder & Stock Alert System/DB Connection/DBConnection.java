package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/medicine_db";
            String user = "root";
            String password = "lily123"; // 🔥 FIX

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ DB Connected!");
            return con;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("DB Connection Failed");
        }
    }
}