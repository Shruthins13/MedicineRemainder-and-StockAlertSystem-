package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StockAlert {

    public static void checkLowStock() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
                "SELECT * FROM medicines WHERE quantity <= 5"
            );

            System.out.println("\n⚠️ LOW STOCK ALERT ⚠️");
            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println(
                    rs.getString("medicine_name") +
                    " | Remaining: " + rs.getInt("quantity")
                );
            }

            if (!found) {
                System.out.println("All medicines are sufficiently stocked.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
