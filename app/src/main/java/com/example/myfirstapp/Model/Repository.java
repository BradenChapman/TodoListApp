package com.example.myfirstapp.Model;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<TodoListItem> todoItems;

    public Repository() {
        todoItems = new ArrayList<>();
    }

    public void addItem(TodoListItem item) {
        todoItems.add(item);
    }

    public List<TodoListItem> getTodoItems() {
        return todoItems;
    }

}
