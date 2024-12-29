package tasktracker;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private String status;
    private String createdAt;
    
    public Task(String description) {
        this.id = idCounter++;
        this.description = description;
        this.status = "todo"; // Default status
        this.createdAt = java.time.LocalDateTime.now().toString();
    }

    // Getters and setters for properties
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description + ", Status: " + status + ", Created At: " + createdAt;
    }
}
