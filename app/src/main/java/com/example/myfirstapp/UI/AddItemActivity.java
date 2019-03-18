package com.example.myfirstapp.UI;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Model.TodoListItem;
import com.example.myfirstapp.R;

public class AddItemActivity extends AppCompatActivity {

    private EditText titleField;
    private EditText descriptionField;
    private EditText dueDateField;

    private TodoListViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        titleField = findViewById(R.id.title_input);
        descriptionField = findViewById(R.id.description_input);
        dueDateField = findViewById(R.id.due_date_input);

        viewModel = ViewModelProviders.of(this).get(TodoListViewModel.class);
    }

    public void onAddPressed(View view) {
        String title = titleField.getText().toString();
        String description = descriptionField.getText().toString();
        String dueDate = dueDateField.getText().toString();

        TodoListItem item = new TodoListItem(title, description, dueDate);
        viewModel.addTodoListItem(item);

        finish();

    }
}
