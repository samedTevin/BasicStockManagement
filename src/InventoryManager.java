import java.sql.*;
import java.util.Scanner;

public class InventoryManager {

    private Connection connection;
    private DbHelper dbHelper = new DbHelper();
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Scanner scanner = new Scanner(System.in);
    private ProductInputHandler productInputHandler;
    private Product product;

    public InventoryManager() {
        productInputHandler = new ProductInputHandler();
    }

    public void addProduct() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "INSERT INTO product (product_name,brand,country_code,price,stock_quantity) VALUES (?,?,?,?,?)";

            product = productInputHandler.getProductForAdd();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setString(3, product.getCountryCode());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getStockQuantity());
            int result = preparedStatement.executeUpdate();
            System.out.println("Product has been inserted : " + result + " product has been affected.");
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

    }

    public void removeProduct() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();

            String sql = "DELETE FROM product WHERE id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productInputHandler.getId());
            int result = preparedStatement.executeUpdate();
            System.out.println("Product has been deleted : " + result + " product has been affected.");
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    public void updateProduct() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "UPDATE product SET product_name=?,brand=?,country_code=?,price=?,stock_quantity=? WHERE id = ?";
            int result;

            product = productInputHandler.getProductForUpdate();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setString(2, product.getBrand());
            preparedStatement.setString(3, product.getCountryCode());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getStockQuantity());
            preparedStatement.setInt(6, productInputHandler.getId());
            result = preparedStatement.executeUpdate();

            System.out.println("Product has been updated : " + result + " product has been affected.");
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    public void listProducts() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id,product_name,brand,country_code,price,stock_quantity FROM product");
            while (resultSet.next()) {
                System.out.println(
                        "\n- ID: " + resultSet.getString("id") + " " +
                        "\n- Product Name: " + resultSet.getString("product_name") + " " +
                        "\n- Brand: " + resultSet.getString("brand") + " " +
                        "\n- Country Code: " + resultSet.getString("country_code") + " " +
                        "\n- Price: " + resultSet.getDouble("price") + " " +
                        "\n- Stock Quantity: " + resultSet.getInt("stock_quantity") + "\n"
                );

            }
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

}
