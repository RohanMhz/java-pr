package src.app;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            MenuOption.displayOptions(taskManager.hasTasks());
            System.out.print("Choose an option: ");
            String input = scanner.nextLine().trim();

            MenuOption option = MenuOption.fromInput(input, taskManager.hasTasks());
            if (option == null) {
                System.out.println("Invalid option.");
                continue;
            }

            if (option == MenuOption.EXIT) {
                System.out.println("Goodbye!");
                break;
            }

            option.execute(taskManager, scanner);
        }

        scanner.close();
    }
}
