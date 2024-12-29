package tasktracker;


public class Main {
    public static void main(String[] args) {
        // Create a TaskManager instance
        TaskManager taskManager = new TaskManager();
        
        // Sample tasks (you can implement more logic here)
        taskManager.addTask("Buy groceries");
        taskManager.addTask("Read a book");
        
        // List all tasks
        taskManager.listTasks();
    }
}
