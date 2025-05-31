
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<String> tasks = new ArrayList<>();
    private final List<String> completedTasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added.");
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsComplete(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        String completed = tasks.remove(index - 1);
        completedTasks.add(completed);
        System.out.println("Task marked as complete: " + completed);
    }

    public boolean hasTasks() {
        return !tasks.isEmpty();
    }
}
