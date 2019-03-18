package com.example.myfirstapp.Model;

public class TodoListItem {
    private String title;
    private String description;
    private String dueDate; //in format "dd/mm/yyyy"
    private boolean completed;

    public TodoListItem(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        completed = false;
    }

    public String getTitle() { return this.title; }
    public String getDescription() { return this.description; }
    public String getDueDate() { return this.dueDate; }
    public boolean isCompleted() { return this.completed; }

    public void markCompleted() { this.completed = true; }
}
