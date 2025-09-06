import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    static CategoryManager categoryManager;
    static SupplierManager supplierManager;
    static InventoryManager inventoryManager;

    public static void displayMainMenu() throws SQLException {

        int choice = 0;

        while (choice != 9) {
            System.out.println("\n\n");

            System.out.println("---------------------------------------------------------");
            System.out.println("*************|Stock Management System Menu|**************");
            System.out.println("---------------------------------------------------------");
            System.out.println("|                                                       |");
            System.out.println("|             [1] Display Category Menu                 |");
            System.out.println("|                                                       |");
            System.out.println("|             [2] Display Supplier Menu                 |");
            System.out.println("|                                                       |");
            System.out.println("|             [3] Display Product  Menu                 |");
            System.out.println("|                                                       |");
            System.out.println("|             [9]  EXIT                                 |");
            System.out.println("|                                                       |");
            System.out.println("---------------------------------------------------------");


            choice = Validator.validateInput();


            switch (choice) {
                case 1:
                    displayCategoryMenu();
                    break;
                case 2:
                    displaySupplierMenu();
                    break;
                case 3:
                    displayProductMenu();
                    break;
                case 9:
                    exit();
                default:
                    System.out.println("Invalid option");
            }


        }
    }


    public static void displayCategoryMenu() throws SQLException {
        if (categoryManager == null) {
            categoryManager = new CategoryManager(); // Create only once
        }

        int choice = 0;

        while (choice != 9) {

            System.out.println("\n\n");
            System.out.println("---------------------------------------------------------");
            System.out.println("********************|Category Menu|**********************");
            System.out.println("---------------------------------------------------------");
            System.out.println("|                                                       |");
            System.out.println("|             [1] List Categories                       |");
            System.out.println("|                                                       |");
            System.out.println("|             [2] Add Category                          |");
            System.out.println("|                                                       |");
            System.out.println("|             [3] Remove Category                       |");
            System.out.println("|                                                       |");
            System.out.println("|             [4] Update Category                       |");
            System.out.println("|                                                       |");
            System.out.println("|             [9] Return Main Menu                      |");
            System.out.println("|                                                       |");
            System.out.println("---------------------------------------------------------");

            choice = Validator.validateInput();


            switch (choice) {
                case 1:
                    System.out.println("--------------------Category List--------------------");
                    categoryManager.listCategory();
                    System.out.println("-----------------------------------------------------");
                    break;
                case 2:
                    categoryManager.addCategory();
                    break;
                case 3:
                    categoryManager.removeCategory();
                    break;
                case 4:
                    categoryManager.updateCategory();
                    break;
                case 9:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void displaySupplierMenu() throws SQLException {
        if (supplierManager == null) {
            supplierManager = new SupplierManager(); // Create only once
        }

        int choice = 0;

        while (choice != 9) {
            System.out.println("\n\n");
            System.out.println("---------------------------------------------------------");
            System.out.println("********************|Supplier Menu|**********************");
            System.out.println("---------------------------------------------------------");
            System.out.println("|                                                       |");
            System.out.println("|             [1] List Suppliers                        |");
            System.out.println("|                                                       |");
            System.out.println("|             [2] Add Supplier                          |");
            System.out.println("|                                                       |");
            System.out.println("|             [3] Remove Supplier                       |");
            System.out.println("|                                                       |");
            System.out.println("|             [4] Update Supplier                       |");
            System.out.println("|                                                       |");
            System.out.println("|             [9] Return Main Menu                      |");
            System.out.println("|                                                       |");
            System.out.println("---------------------------------------------------------");


            choice = Validator.validateInput();


            switch (choice) {
                case 1:
                    System.out.println("--------------------Supplier List--------------------");
                    supplierManager.listSuppliers();
                    System.out.println("-----------------------------------------------------");
                    break;
                case 2:
                    supplierManager.addSupplier();
                    break;
                case 3:
                    supplierManager.removeSupplier();
                    break;
                case 4:
                    supplierManager.updateSupplier();
                    break;
                case 9:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void displayProductMenu() throws SQLException {
        if (inventoryManager == null) {
            inventoryManager = new InventoryManager();
        }
        int choice = 0;

        while (choice != 9) {
            System.out.println("\n\n");
            System.out.println("---------------------------------------------------------");
            System.out.println("********************|Product Menu|***********************");
            System.out.println("---------------------------------------------------------");
            System.out.println("|                                                       |");
            System.out.println("|             [1] List Products                         |");
            System.out.println("|                                                       |");
            System.out.println("|             [2] Add Product                           |");
            System.out.println("|                                                       |");
            System.out.println("|             [3] Remove Product                        |");
            System.out.println("|                                                       |");
            System.out.println("|             [4] Update Product                        |");
            System.out.println("|                                                       |");
            System.out.println("|             [9] Return Main Menu                      |");
            System.out.println("|                                                       |");
            System.out.println("---------------------------------------------------------");


            choice = Validator.validateInput();


            switch (choice) {
                case 1:
                    System.out.println("--------------------Product List--------------------");
                    inventoryManager.listProducts();
                    System.out.println("-----------------------------------------------------");
                    break;
                case 2:
                    inventoryManager.addProduct();
                    break;
                case 3:
                    inventoryManager.removeProduct();
                    break;
                case 4:
                    inventoryManager.updateProduct();
                    break;
                case 9:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void exit() {

        System.out.println("\n\n");
        System.out.println("---------------------------------------------------------");
        System.out.println("*************|Stock Management System Menu|**************");
        System.out.println("---------------------------------------------------------");
        System.out.println("|                                                       |");
        System.out.println("|             Thanks for using the System               |");
        System.out.println("|                                                       |");
        System.out.println("|                 Have a nice day !                     |");
        System.out.println("|                                                       |");
        System.out.println("|                Credit : Samed Tevin                   |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("---------------------------------------------------------");
        System.exit(0);
    }


}
