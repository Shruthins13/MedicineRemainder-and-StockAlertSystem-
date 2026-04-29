package connection;
import ui.MainMenuUI;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
    	new MainMenuUI();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n💊 MEDICINE REMINDER SYSTEM");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Medicines");
            System.out.println("3. Check Low Stock");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    AddMedicine.addMedicine();
                    break;
                case 2:
                    ViewMedicines.viewMedicines();
                    break;
                case 3:
                    StockAlert.checkLowStock();
                    break;
                case 4:
                    System.out.println("Stay healthy! 👋");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
