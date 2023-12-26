import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/nama_database";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void insertData(PembelianBarang purchase) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO nama_tabel (invoice_number, customer_name, number_phone, product_name, product_price, quantity, cashier_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, purchase.invoiceNumber);
            preparedStatement.setString(2, purchase.customerName);
            preparedStatement.setString(3, purchase.numberPhone);
            preparedStatement.setString(4, purchase.productName);
            preparedStatement.setDouble(5, purchase.productPrice);
            preparedStatement.setInt(6, purchase.quantity);
            preparedStatement.setString(7, purchase.cashierName);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void retrieveDataAndDisplay() {
        try (Connection connection = getConnection()) {
            String query = "SELECT * FROM nama_tabel";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String invoiceNumber = resultSet.getString("invoice_number");
                String customerName = resultSet.getString("customer_name");
                String numberPhone = resultSet.getString("number_phone");
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                int quantity = resultSet.getInt("quantity");
                String cashierName = resultSet.getString("cashier_name");

                System.out.println("-------------------------");
                System.out.println("Transaction Details:");
                System.out.println("Invoice Number: " + invoiceNumber);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Number Phone: " + numberPhone);
                System.out.println("Product Name: " + productName);
                System.out.println("Product Price: Rp" + productPrice);
                System.out.println("Quantity: " + quantity);
                System.out.println("Cashier Name: " + cashierName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(String invoiceNumber, double newProductPrice) {
        try (Connection connection = getConnection()) {
            String query = "UPDATE nama_tabel SET product_price = ? WHERE invoice_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, newProductPrice);
            preparedStatement.setString(2, invoiceNumber);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(String invoiceNumber) {
        try (Connection connection = getConnection()) {
            String query = "DELETE FROM nama_tabel WHERE invoice_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, invoiceNumber);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
