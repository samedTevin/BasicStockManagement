import java.sql.*;

public class CategoryManager {

    private Connection connection;
    private DbHelper dbHelper = new DbHelper();
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Category category;
    private CategoryInputHandler categoryInputHandler;

    public CategoryManager() {
        categoryInputHandler = new CategoryInputHandler();
    }

    public void addCategory() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            int result;
            String sql = "INSERT INTO category(category_name) VALUES(?)";
            preparedStatement = connection.prepareStatement(sql);
            category = categoryInputHandler.getCategoryForAdd();
            preparedStatement.setString(1, category.getName());
            result = preparedStatement.executeUpdate();
            System.out.println("Category has been inserted : " + result + " category has been affected.");
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

    }

    public void removeCategory() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            int result;

            String sql = "DELETE FROM category WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryInputHandler.getId());
            result = preparedStatement.executeUpdate();
            System.out.println("Category has been removed : " + result + " category has been affected.");
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    public void updateCategory() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "UPDATE category SET category_name=? WHERE id=?";
            int result;

            category = categoryInputHandler.getCategoryForUpdate();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, category.getName());
            preparedStatement.setInt(2, categoryInputHandler.getId());

            result = preparedStatement.executeUpdate();
            System.out.println("Category has been updated : " + result + " category has been affected.");
        } catch (SQLException exception) {
            dbHelper.showError(exception);
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    public void listCategory() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id,category_name FROM Category");
            while (resultSet.next()) {
                System.out.println(
                        "- ID: " + resultSet.getInt("id") + " " +
                                "\n- Category Name: " + resultSet.getString("category_name") + "\n"
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
