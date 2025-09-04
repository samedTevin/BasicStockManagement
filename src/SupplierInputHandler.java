import java.util.Scanner;
public class SupplierInputHandler {

    Scanner scanner = new Scanner(System.in);
    Supplier supplier;
    private int id;
    private String name;
    private String address;
    private String phoneNum;
    private String email;

    public Supplier getSupplierForAdd(){
        System.out.print("Enter Supplier's Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Supplier'S Address: ");
        address = scanner.nextLine();
        System.out.print("Enter Supplier's Phone Number: ");
        phoneNum = scanner.nextLine();
        System.out.print("Enter Supplier's Email: ");
        email = scanner.nextLine();

        supplier = new Supplier(name,address,phoneNum,email);
        return supplier;
    }

    public Supplier getSupplierForUpdate(){
        System.out.print("Enter the new Supplier's Name: ");
        name = scanner.nextLine();
        System.out.print("Enter the new Supplier's Address: ");
        address = scanner.nextLine();
        System.out.print("Enter the new Supplier's Phone Number: ");
        phoneNum = scanner.nextLine();
        System.out.print("Enter the new Supplier's Email: ");
        email = scanner.nextLine();

        supplier = new Supplier(name,address,phoneNum,email);

        return supplier;
    }

    public int getId(){
        int id;
        System.out.print("Enter Supplier's Id: ");
        id = scanner.nextInt();
        return id;
    }
}
