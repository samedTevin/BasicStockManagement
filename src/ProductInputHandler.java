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

        System.out.print("Enter the product name: ");
        productName = scanner.nextLine();
        System.out.print("Enter the product brand: ");
        brand = scanner.nextLine();
        System.out.print("Enter the product country code: ");
        countryCode = scanner.nextLine();
        System.out.print("Enter the product price: ");
        price = scanner.nextDouble();
        System.out.print("Enter the stock quantity: ");
        stockQuantity = scanner.nextInt();

        product = new Product(productName, brand, countryCode, price, stockQuantity);

        return product;
    }

    public Product getProductForUpdate() {
        System.out.print("Enter the new product name: ");
        productName = scanner.nextLine();
        System.out.print("Enter the new product brand: ");
        brand = scanner.nextLine();
        System.out.print("Enter the new product country code: ");
        countryCode = scanner.nextLine();
        System.out.print("Enter the new product price: ");
        price = scanner.nextDouble();
        System.out.print("Enter the new stock quantity: ");
        stockQuantity = scanner.nextInt();

        product = new Product(productName, brand, countryCode, price, stockQuantity);
        return product;
    }

    public int getId() {
        int id;
        System.out.print("Enter product id: ");
        id = scanner.nextInt();
        return id;
    }

}



















