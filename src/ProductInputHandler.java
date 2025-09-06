import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductInputHandler {


    private int id;
    private String productName;
    private String brand;
    private String countryCode;
    private double price;
    private int stockQuantity;
    private final Scanner scanner = new Scanner(System.in);
    private Product product;

    public Product getProductForAdd() {

        boolean flag = true;

        System.out.print("Enter the product name: ");
        productName = scanner.nextLine();
        System.out.print("Enter the product brand: ");
        brand = scanner.nextLine();
        System.out.print("Enter the product country code: ");
        countryCode = scanner.nextLine();

        while (flag) {
            try {
                System.out.print("Enter the product price: ");
                price = scanner.nextDouble();
                System.out.print("Enter the stock quantity: ");
                stockQuantity = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }
        product = new Product(productName, brand, countryCode, price, stockQuantity);

        return product;
    }

    public Product getProductForUpdate() {

        boolean flag = true;

        System.out.print("Enter the new product name: ");
        productName = scanner.nextLine();
        System.out.print("Enter the new product brand: ");
        brand = scanner.nextLine();
        System.out.print("Enter the new product country code: ");
        countryCode = scanner.nextLine();
        while (flag) {
            try {
                System.out.print("Enter the new product price: ");
                price = scanner.nextDouble();
                System.out.print("Enter the new stock quantity: ");
                stockQuantity = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }

        product = new Product(productName, brand, countryCode, price, stockQuantity);
        return product;
    }

    public int getId() {

        int id = 0;
        boolean flag = true;

        while (flag) {

            try {
                System.out.print("Enter product id: ");
                id = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }

        }

        return id;
    }

}



















