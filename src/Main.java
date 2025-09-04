import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        InventoryManager manager = new InventoryManager();

        CategoryManager categoryManager = new CategoryManager();

        //manager.listProducts();

        //manager.addProduct(ProductValidator.validateAddProduct());

        // manager.removeProduct();

        // manager.updateProduct(ProductValidator.validateUpdateProduct());

        categoryManager.listCategory();
    }
}