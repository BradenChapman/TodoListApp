package com.example.myfirstapp.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "todo_item_table")
public class TodoListItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;
    private String dueDate; //in format "dd/mm/yyyy"
    private boolean completed;
    private int priority;

    public TodoListItem(String title, String description, String dueDate, boolean completed, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.priority = priority;
    }

    public String getTitle() { return this.title; }
    public String getDescription() { return this.description; }
    public String getDueDate() { return this.dueDate; }
    public int getId() { return this.id;}
    public boolean isCompleted() { return this.completed; }
    public int getPriority() { return this.priority; }

    public void markCompleted() { this.completed = true; }
    public void setId(int id) { this.id = id; }
}
