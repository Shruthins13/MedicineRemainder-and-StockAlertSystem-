package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddMedicine {

    public static void addMedicine() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Medicine Name: ");
            String name = sc.nextLine();

            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine();

            System.out.print("Expiry Date (YYYY-MM-DD): ");
            String expiry = sc.nextLine();

            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO medicines (medicine_name, quantity, expiry_date) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, qty);
            ps.setString(3, expiry);

            ps.executeUpdate();
            con.close();

            System.out.println("✅ Medicine added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
