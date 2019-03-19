package com.example.myfirstapp.UI;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myfirstapp.Model.Priority;
import com.example.myfirstapp.Model.TodoListItem;
import com.example.myfirstapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    private EditText titleField;
    private EditText descriptionField;
    private EditText dueDateField;
    private Spinner prioritySpinner;

    private TodoListViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        titleField = findViewById(R.id.title_input);
        descriptionField = findViewById(R.id.description_input);
        dueDateField = findViewById(R.id.due_date_input);
        prioritySpinner = findViewById(R.id.spinner_priority);

        //Creates the fields for the priority spinner dropdown
        ArrayList<String> listOfPriorityStrings = new ArrayList<>();
        List<Priority> pList = Arrays.asList(Priority.values());
        for(Priority p : pList) {
            listOfPriorityStrings.add(p.getPriority());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listOfPriorityStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(adapter);


        viewModel = ViewModelProviders.of(this).get(TodoListViewModel.class);
    }

    public void onAddPressed(View view) {
        String title = titleField.getText().toString();
        String description = descriptionField.getText().toString();
        String dueDate = dueDateField.getText().toString();
        String priority = (String) prioritySpinner.getSelectedItem();

        if (title.trim().isEmpty() || description.trim().isEmpty() || dueDate.trim().isEmpty() || priority.trim().isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

        TodoListItem item = new TodoListItem(title, description, dueDate, false, Integer.valueOf(priority));
        viewModel.insert(item);

        finish();

    }
}
