package com.example.myfirstapp.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myfirstapp.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the "View Tod-List" button*/
    public void viewTodoList(View view) {
        Intent intent = new Intent(this, ViewTodoListActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Add Item button */
    public void addTodoListItem(View view) {
        Intent intent = new Intent(this, AddEditItemActivity.class);
        startActivity(intent);
    }

}
