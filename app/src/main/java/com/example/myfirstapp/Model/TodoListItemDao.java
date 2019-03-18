package com.example.myfirstapp.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TodoListItemDao {

    @Insert
    void insert(TodoListItem item);

    @Update
    void update(TodoListItem item);

    @Delete
    void delete(TodoListItem item);

    @Query("DELETE FROM todo_item_table")
    void deleteAllItems();

    @Query("SELECT * FROM todo_item_table ORDER BY priority DESC")
    LiveData<List<TodoListItem>> getAllItems();

}
