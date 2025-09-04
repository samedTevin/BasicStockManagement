import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        InventoryManager manager = new InventoryManager();

        CategoryManager categoryManager = new CategoryManager();

        SupplierManager supplierManager = new SupplierManager();

        // manager.listProducts();

        //manager.addProduct(); Works

        // manager.removeProduct();

        // manager.updateProduct();

        //supplierManager.addSupplier();
        //supplierManager.listSuppliers();
        //supplierManager.removeSupplier();
        //supplierManager.updateSupplier();
    }
}