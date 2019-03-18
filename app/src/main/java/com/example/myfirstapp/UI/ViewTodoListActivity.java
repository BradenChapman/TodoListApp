package com.example.myfirstapp.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myfirstapp.Model.TodoListItem;
import com.example.myfirstapp.R;

import java.util.List;


public class ViewTodoListActivity extends AppCompatActivity {
    private TodoListViewModel todoListViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todolist);

        todoListViewModel = ViewModelProviders.of(this).get(TodoListViewModel.class);
        todoListViewModel.getAllItems().observe(this, new Observer<List<TodoListItem>>() {
            @Override
            public void onChanged(@Nullable List<TodoListItem> todoListItems) {
                //update RecyclerView
                Toast.makeText(ViewTodoListActivity.this, "Created", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
