package tasktracker;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    public void listTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
