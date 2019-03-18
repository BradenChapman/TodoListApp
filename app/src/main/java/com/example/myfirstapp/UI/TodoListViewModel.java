package com.example.myfirstapp.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.myfirstapp.Model.Repository;
import com.example.myfirstapp.Model.TodoListItem;

import java.util.ArrayList;
import java.util.List;

public class TodoListViewModel extends AndroidViewModel {
    private Repository repo = new Repository();

    public List<TodoListItem> getTodoList() {
        return repo.getTodoItems();
    }

    public void addTodoListItem(TodoListItem item) {
        repo.addItem(item);
    }

    public TodoListViewModel(Application application) {
        super(application);
    }
}
