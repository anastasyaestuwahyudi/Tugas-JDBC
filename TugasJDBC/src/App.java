import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager databaseManager = new DatabaseManager();

        try {

            System.out.print("Enter the Invoice Number: ");
            String invoiceNumber = scanner.nextLine();

            System.out.print("Enter the Customer Name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter the Number Phone: ");
            String numberPhone = scanner.nextLine();

            System.out.print("Enter the Product Name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter the Product Price: ");
            double productPrice = scanner.nextDouble();

            System.out.print("Enter the Quantity: ");
            int quantity = scanner.nextInt();

            scanner.nextLine(); // Membuang newline

            System.out.print("Enter the Cashier's Name: ");
            String cashierName = scanner.nextLine();

            Pembelian purchase = new Pembelian(invoiceNumber, customerName, numberPhone, productName, productPrice,
                    quantity, cashierName);

            purchase.displayInfo();
        } catch (Exception e) {
            System.out.println("Something is wrong: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}