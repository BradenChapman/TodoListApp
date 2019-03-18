package com.example.myfirstapp.UI;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfirstapp.Model.TodoListItem;
import com.example.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    private List<TodoListItem> todoList = new ArrayList<>();

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder viewHolder, int i) {
        TodoListItem item = todoList.get(i);

        viewHolder.title.setText(item.getTitle());
        viewHolder.description.setText(item.getDescription());
        viewHolder.dueDate.setText(item.getDueDate());
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public void setTodoList(List<TodoListItem> list) {
        todoList = list;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private TextView dueDate;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title_text);
            description = view.findViewById(R.id.description_text);
            dueDate = view.findViewById(R.id.due_date_text);
        }

    }
}
