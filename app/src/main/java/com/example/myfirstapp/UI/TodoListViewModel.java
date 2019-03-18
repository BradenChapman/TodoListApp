package com.example.myfirstapp.UI;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.myfirstapp.Model.Repository;
import com.example.myfirstapp.Model.TodoListItem;

import java.util.List;


public class TodoListViewModel extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<TodoListItem>> allItems;

    public TodoListViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allItems = repository.getAllItems();
    }

    public void insert(TodoListItem item) { repository.insert(item); }
    public void update(TodoListItem item) { repository.update(item); }
    public void delete(TodoListItem item) { repository.delete(item); }
    public void deleteAllItems() { repository.deleteAllItems(); }
    public LiveData<List<TodoListItem>> getAllItems() { return repository.getAllItems(); }
}
