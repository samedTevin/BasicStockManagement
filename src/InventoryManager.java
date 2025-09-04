import java.sql.*;
import java.util.Scanner;

public class InventoryManager {

    Connection connection;
    DbHelper dbHelper = new DbHelper();
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Scanner scanner = new Scanner(System.in);

    public InventoryManager(){
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        }
    }

    public void addProduct(Product product) throws SQLException{

        try{
            String sql = "INSERT INTO product (product_name,brand,country_code,price,stock_quantity) VALUES (?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getBrand());
            preparedStatement.setString(3,product.getCountryCode());
            preparedStatement.setInt(4,product.getPrice());
            preparedStatement.setInt(5,product.getStockQuantity());
            int result = preparedStatement.executeUpdate();
            System.out.println("Product has been inserted : " + result + " product has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            statement.close();
            connection.close();
        }

    }

    public void removeProduct() throws SQLException{
        try{
            String sql = "DELETE FROM product WHERE id=?";
            int id;
            preparedStatement = connection.prepareStatement(sql);

            System.out.print("Enter the id of the product : ");
            id = scanner.nextInt();
            preparedStatement.setInt(1,id);
            int result = preparedStatement.executeUpdate();
            System.out.println("Product has been deleted : " + result + " product has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            statement.close();
            connection.close();
        }
    }

    public void updateProduct(Product product) throws SQLException{
        try{
            String sql = "UPDATE product SET product_name=?,brand=?,country_code=?,price=?,stock_quantity=? WHERE id = ?";
            int result;
            int id;

            System.out.print("Enter the id of the product : ");
            id = scanner.nextInt();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setString(2,product.getBrand());
            preparedStatement.setString(3,product.getCountryCode());
            preparedStatement.setInt(4,product.getPrice());
            preparedStatement.setInt(5,product.getStockQuantity());
            preparedStatement.setInt(6,id);
            result = preparedStatement.executeUpdate();

            System.out.println("Product has been updated : " + result + " product has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public void listProducts() throws SQLException {
        try{
            resultSet = statement.executeQuery("SELECT id,product_name,brand,country_code,price,stock_quantity FROM product");
            while(resultSet.next()){
                System.out.println(
                        resultSet.getString("id") +
                        resultSet.getString("product_name") +
                        resultSet.getString("brand") +
                        resultSet.getString("country_code") +
                        resultSet.getDouble("price") +
                        resultSet.getInt("stock_quantity")
                );
            }
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally {
            connection.close();
        }
    }

}
