import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CategoryInputHandler {

    private Scanner scanner = new Scanner(System.in);
    private int id;
    private String name;
    private Category category;

    public Category getCategoryForAdd() {
        System.out.print("Enter the new Category name: ");
        name = scanner.nextLine();
        category = new Category(name);
        return category;
    }


    public Category getCategoryForUpdate() {
        System.out.print("Enter the new Category name: ");
        name = scanner.nextLine();
        category = new Category(name);
        return category;
    }

    public int getId() {

        int id = 0;
        boolean flag = true;

        while (flag) {
            try {
                System.out.print("Enter the Category id: ");
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
