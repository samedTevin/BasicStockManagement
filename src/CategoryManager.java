import java.sql.*;

public class CategoryManager {

    Connection connection;
    DbHelper dbHelper = new DbHelper();
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Category category;
    CategoryInputHandler categoryInputHandler;

    public CategoryManager(){
        try{
            connection = dbHelper.getConnection();
            categoryInputHandler = new CategoryInputHandler();
        }catch(SQLException exception){
            dbHelper.showError(exception);
        }
    }

    public void addCategory() throws SQLException {

        try{
            int result;
            String sql = "INSERT INTO category(name) VALUES(?)";
            preparedStatement = connection.prepareStatement(sql);
            category = categoryInputHandler.getCategoryForAdd();
            preparedStatement.setString(1,category.getName() );
            result = preparedStatement.executeUpdate();
            System.out.println("Category has been deleted : " + result + " category has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            preparedStatement.close();
            connection.close();
        }

    }

    public void removeCategory() throws SQLException{
        try{
            int result;

            String sql = "DELETE FROM category WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,categoryInputHandler.getId());
            result = preparedStatement.executeUpdate();
            System.out.println("Category has been removed : " + result + " category has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            preparedStatement.close();
            connection.close();
        }
    }

    public void updateCategory() throws SQLException{
        try{
            String sql = "UPDATE category SET name=? WHERE id=?";
            int result;

            category = categoryInputHandler.getCategoryForUpdate();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,category.getName());
            preparedStatement.setInt(2,categoryInputHandler.getId());

            result = preparedStatement.executeUpdate();
            System.out.println("Category has been updated : " + result + " category has been affected.");
        }
        catch(SQLException exception){
            dbHelper.showError(exception);
        }
        finally{
            preparedStatement.close();
            connection.close();
        }
    }

    public void listCategory() throws SQLException {
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id,category_name FROM Category");
            while(resultSet.next()){
                System.out.println(
                        resultSet.getInt("id") +
                        resultSet.getString("category_name")
                );
            }
        }
        catch (SQLException exception){
            dbHelper.showError(exception);
        }
        finally {
            statement.close();
            connection.close();
        }
    }
}
