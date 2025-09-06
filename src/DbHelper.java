import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private String userName = "root";
    private String password = "YOURPASSWORD";
    private String dbUrl = "jdbc:mysql://localhost:3306/market_stock";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showError(SQLException exception) {
        System.out.println("Database connection error : " + exception.getMessage());
        System.out.println("Error Code : " + exception.getErrorCode());
    }


}
