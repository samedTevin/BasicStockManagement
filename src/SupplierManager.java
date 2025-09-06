import java.sql.*;

public class SupplierManager {

    private DbHelper dbHelper = new DbHelper();
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private Supplier supplier;
    private SupplierInputHandler supplierInputHandler;
    private ResultSet resultSet;

    public SupplierManager(){
            supplierInputHandler = new SupplierInputHandler();
    }

    public void addSupplier() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = dbHelper.getConnection();
            int result;
            String sql = "INSERT INTO supplier(supplier_name,address,phone_num,email) VALUES(?,?,?,?)";
            supplier = supplierInputHandler.getSupplierForAdd();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,supplier.getName());
            preparedStatement.setString(2,supplier.getAddress());
            preparedStatement.setString(3,supplier.getPhoneNum());
            preparedStatement.setString(4,supplier.getEmail());

            result = preparedStatement.executeUpdate();

            System.out.println("Supplier has been inserted : " + result + " supplier has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }

    }
    public void removeSupplier() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = dbHelper.getConnection();
            int result;
            String sql = "DELETE FROM supplier WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,supplierInputHandler.getId());
            result = preparedStatement.executeUpdate();
            System.out.println("Supplier has been deleted : " + result + " supplier has been affected.");

        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            if(preparedStatement !=null) preparedStatement.close();
            if(connection != null) connection.close();
        }


    }
    public void updateSupplier() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = dbHelper.getConnection();
            int result;
            supplier = supplierInputHandler.getSupplierForUpdate();
            String sql = "UPDATE supplier SET supplier_name=?,address=?,phone_num=?,email=? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,supplier.getName());
            preparedStatement.setString(2,supplier.getAddress());
            preparedStatement.setString(3,supplier.getPhoneNum());
            preparedStatement.setString(4,supplier.getEmail());
            preparedStatement.setInt(5,supplierInputHandler.getId());
            result = preparedStatement.executeUpdate();
            System.out.println("Supplier has been updated : " + result + " supplier has been affected.");

        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            if(preparedStatement != null) preparedStatement.close();
            if(connection != null) connection.close();
        }
    }
    public void listSuppliers() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT id,supplier_name,address,phone_num,email FROM supplier";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(
                        "\n- ID: " + resultSet.getInt("id") + " " +
                        "\n- Supplier Name: " + resultSet.getString("supplier_name") + " " +
                        "\n- Address: " + resultSet.getString("address") + " " +
                        "\n- Phone Number: " + resultSet.getString("phone_num") + " " +
                        "\n- Email: " + resultSet.getString("email") + "\n"
                );
            }
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            if(resultSet != null) resultSet.close();
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }
    }
}
