
import java.util.Scanner;

public enum MenuOption {
    ADD_TASK("1") {
        @Override
        public void execute(TaskManager manager, Scanner scanner) {
            System.out.print("Enter task description: ");
            String task = scanner.nextLine();
            manager.addTask(task);
        }
    },
    LIST_TASKS("2") {
        @Override
        public void execute(TaskManager manager, Scanner scanner) {
            manager.listTasks();
        }
    },
    MARK_COMPLETE("3") {
        @Override
        public void execute(TaskManager manager, Scanner scanner) {
            manager.listTasks();
            if (!manager.hasTasks())
                return;

            System.out.print("Enter the number of the task to mark as complete: ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                manager.markTaskAsComplete(index);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    },
    EXIT("4") {
        @Override
        public void execute(TaskManager manager, Scanner scanner) {
            // Do nothing here, handled in Main
        }
    };

    private final String optionNumber;

    MenuOption(String optionNumber) {
        this.optionNumber = optionNumber;
    }

    public abstract void execute(TaskManager manager, Scanner scanner);

    public static MenuOption fromInput(String input, boolean hasTasks) {
        for (MenuOption option : values()) {
            if (option.optionNumber.equals(input)) {
                if (!hasTasks && option == MARK_COMPLETE)
                    return null;
                return option;
            }
        }
        return null;
    }

    public static void displayOptions(boolean hasTasks) {
        System.out.println("\n1. Add Task\n2. List Tasks");
        if (hasTasks) {
            System.out.println("3. Mark Task as Complete\n4. Exit");
        } else {
            System.out.println("3. Exit");
        }
    }
}
