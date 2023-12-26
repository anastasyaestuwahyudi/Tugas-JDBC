
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pembelian {
    protected String invoiceNumber;
    protected String customerName;
    protected String numberPhone;
    protected String productName;
    protected double productPrice;
    protected int quantity;
    protected String cashierName;

    public Pembelian(String invoiceNumber, String customerName, String numberPhone, String productName,
            double productPrice, int quantity, String cashierName) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.numberPhone = numberPhone;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.cashierName = cashierName;
    }

    public void displayInfo() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss z");

        System.out.println(" ");
        System.out.println("----------------");
        System.out.println("MY MINIMARKET");
        System.out.println("----------------");
        System.out.println("Tanggal        :" + dateFormat.format(new Date()));
        System.out.println("Jam            :" + timeFormat.format(new Date()));
        System.out.println("-------------------------");
        System.out.println("Invoice Number : " + invoiceNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Number Phone   : " + numberPhone);
        System.out.println("Product Name   : " + productName);
        System.out.println("Product Price  : Rp" + productPrice);
        System.out.println("Quantity       : " + quantity);
        System.out.println("Total Price    : Rp" + calculateTotalPrice());
        System.out.println(" ");
        System.out.println("Cashier Name   : " + cashierName);
        System.out.println("Cashier Name (Upper Case): " + cashierName.toUpperCase());
        System.out.println("Cashier Name (Lower Case): " + cashierName.toLowerCase());

        System.out.println("-------------------------");
        System.out.println("Thanks!please come back");

        System.out.println("-------------------------");
        System.out.println("Thanks for shopping with us!");
        System.out.println("Transaction Details:");
        System.out.println("Total Payment: Rp" + calculateTotalPrice());
        System.out.println("Payment Method: Cash");
        System.out.println("Items Purchased: ");
        System.out.println("- " + productName + " (" + quantity + " pcs) - Rp" + calculateTotalPrice());

        System.out.println("-------------------------");
        System.out.println("We hope to see you again!");
    }

    public double calculateTotalPrice() {
        return productPrice * quantity;
    }

    public String formatCashierName() {
        String[] words = cashierName.split("\\s+");
        StringBuilder formattedName = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                formattedName.append(word.substring(0, 1).toUpperCase())
                        .append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        return formattedName.toString().trim();
    }
}
