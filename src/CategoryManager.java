import java.sql.*;

public class CategoryManager {

    Connection connection;
    DbHelper dbHelper = new DbHelper();
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public CategoryManager(){
        try{
            connection = dbHelper.getConnection();
        }catch(SQLException exception){
            dbHelper.showError(exception);
        }
    }

    public void addCategory(Category category){

    }

    public void removeCategory(Category category){

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
