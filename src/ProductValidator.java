import java.util.Scanner;

public class ProductValidator  {
        private int id;
        private static String productName;
        private static String brand;
        private static String countryCode;
        private static int price;
        private static int stockQuantity;
        static Scanner scanner = new Scanner(System.in);
        static Product product;

        public static Product validateAddProduct(){

            System.out.print("Enter the product name: ");
            productName = scanner.nextLine();
            System.out.print("Enter the product brand: ");
            brand = scanner.nextLine();
            System.out.print("Enter the product country code: ");
            countryCode = scanner.nextLine();
            System.out.print("Enter the product price: ");
            price = scanner.nextInt();
            System.out.print("Enter the stock quantity: ");
            stockQuantity = scanner.nextInt();

            product = new Product(productName, brand, countryCode, price, stockQuantity);

            return product;
        }

        public static Product validateUpdateProduct(){
            System.out.print("Enter the new product name: ");
            productName = scanner.nextLine();
            System.out.print("Enter the new product brand: ");
            brand = scanner.nextLine();
            System.out.print("Enter the new product country code: ");
            countryCode = scanner.nextLine();
            System.out.print("Enter the new product price: ");
            price = scanner.nextInt();
            System.out.print("Enter the new stock quantity: ");
            stockQuantity = scanner.nextInt();

            product = new Product(productName, brand, countryCode, price, stockQuantity);
            return product;
        }
    }

