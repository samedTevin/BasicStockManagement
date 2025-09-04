import java.util.Scanner;

public class CategoryInputHandler {

    private Scanner scanner = new Scanner(System.in);
    private int id;
    private String name;
    private Category category;

    public Category getCategoryForAdd(){
        System.out.print("Enter product name: ");
        name = scanner.nextLine();
        category = new Category(name);
        return category;
    }


    public Category getCategoryForUpdate(){
        System.out.print("Enter the new product name: ");
        name = scanner.nextLine();
        category = new Category(name);
        return category;
    }

    public int getId(){
        System.out.print("Enter the product id: ");
        id = scanner.nextInt();
        return id;
    }

}
