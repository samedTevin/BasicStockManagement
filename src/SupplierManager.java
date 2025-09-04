import java.sql.*;

public class SupplierManager {

    DbHelper dbHelper = new DbHelper();
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;
    Supplier supplier;
    SupplierInputHandler supplierInputHandler;
    ResultSet resultSet;

    public SupplierManager(){
        try{
            connection = dbHelper.getConnection();
            supplierInputHandler = new SupplierInputHandler();
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
    }

    public void addSupplier() throws SQLException {

        try{
            int result;
            String sql = "INSERT INTO supplier(supplier_name,address,phone_num,email) VALUES(?,?,?,?)";
            supplier = supplierInputHandler.getSupplierForAdd();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,supplier.getName());
            preparedStatement.setString(2,supplier.getAddress());
            preparedStatement.setString(3,supplier.getPhoneNum());
            preparedStatement.setString(4,supplier.getEmail());

            result = preparedStatement.executeUpdate();

            System.out.println("Supplier has been inserted : " + result + " product has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            preparedStatement.close();
            connection.close();
        }

    }
    public void removeSupplier() throws SQLException{

        try{
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
        try{
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
            preparedStatement.close();
            connection.close();
        }
    }
    public void listSuppliers() throws SQLException {
        try{
            statement = connection.createStatement();
            String sql = "SELECT id,supplier_name,address,phone_num,email FROM supplier";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(
                        resultSet.getInt("id") +
                        resultSet.getString("supplier_name") +
                        resultSet.getString("address") +
                        resultSet.getString("phone_num") +
                        resultSet.getString("email")
                );
            }
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            statement.close();
            connection.close();
        }
    }
}
