package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewMedicines {

    public static void viewMedicines() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM medicines");

            System.out.println("\n--- MEDICINE LIST ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("medicine_id") + " | " +
                    rs.getString("medicine_name") + " | Qty: " +
                    rs.getInt("quantity") + " | Exp: " +
                    rs.getDate("expiry_date")
                );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
