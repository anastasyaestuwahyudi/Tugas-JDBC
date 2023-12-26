public class PembelianBarang extends Pembelian implements TotalPayment {

    public PembelianBarang(String invoiceNumber, String customerName, String numberPhone, String productName,
            double productPrice,
            int quantity, String cashierName) {
        super(invoiceNumber, customerName, numberPhone, productName, productPrice, quantity, cashierName);
    }

    @Override
    public double calculateTotalPrice() {
        return productPrice * quantity;

    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Total Payment: Rp" + calculateTotalPrice());
    }
}
