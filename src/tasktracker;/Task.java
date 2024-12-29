package tasktracker;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description , Status;
    private LocalDateTime createdAt , updatedAt;

    public Task(int id , String description , String Status){
        this.id = id;
        this.description = description;
        this.Status = Status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String getStatus(){
        return Status;
    }
    public void setStatus(String Status){
        this.Status = Status;
        this.updatedAt = LocalDateTime.now();
    }
    public void setDiscription(String description){
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public LocalDateTime getupdatedAT(){
        return updatedAt;
    }
}