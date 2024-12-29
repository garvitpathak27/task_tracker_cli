package tasktracker;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final String fileName = "tasks.json";
    private List<Task> tasks = new ArrayList<>();

    public TaskManager() {
        loadTasks();
    }

    private void loadTasks() {
        Path filePath = Paths.get(fileName);
        if (Files.exists(filePath)) {
            try {
                String content = Files.readString(filePath);
                JSONArray jsonArray = new JSONArray(content);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    Task task = new Task(
                            obj.getInt("id"),
                            obj.getString("description"),
                            obj.getString("status")
                    );
                    tasks.add(task);
                }
            } catch (IOException e) {
                System.out.println("Error loading tasks: " + e.getMessage());
            }
        }
    }

    private void saveTasks() {
        JSONArray jsonArray = new JSONArray();
        for (Task task : tasks) {
            JSONObject obj = new JSONObject();
            obj.put("id", task.getId());
            obj.put("description", task.getDescription());
            obj.put("status", task.getStatus());
            obj.put("createdAt", task.getCreatedAt().toString());
            obj.put("updatedAt", task.getUpdatedAt().toString());
            jsonArray.put(obj);
        }

        try {
            Files.writeString(Paths.get(fileName), jsonArray.toString(2));
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void addTask(String description) {
        int id = tasks.size() + 1;
        Task task = new Task(id, description, "todo");
        tasks.add(task);
        saveTasks();
        System.out.println("Task added successfully (ID: " + id + ")");
    }

    public void updateTask(int id, String description) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setDescription(description);
            saveTasks();
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void deleteTask(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            tasks.remove(task);
            saveTasks();
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void markTaskStatus(int id, String status) {
        Task task = findTaskById(id);
        if (task != null) {
            task.setStatus(status);
            saveTasks();
            System.out.println("Task marked as " + status + ".");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void listTasks(String status) {
        for (Task task : tasks) {
            if (status == null || task.getStatus().equals(status)) {
                System.out.println(task.getId() + ". " + task.getDescription() + " [" + task.getStatus() + "]");
            }
        }
    }

    private Task findTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
