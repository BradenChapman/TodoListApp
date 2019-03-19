package com.example.myfirstapp.UI;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myfirstapp.Model.TodoListItem;
import com.example.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;


public class ItemAdapter extends ListAdapter<TodoListItem, ItemAdapter.MyViewHolder> {
    private OnItemClickListener listener;

    public ItemAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<TodoListItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<TodoListItem>() {
        @Override
        public boolean areItemsTheSame(@NonNull TodoListItem todoListItem, @NonNull TodoListItem t1) {
            return todoListItem.getId() == t1.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull TodoListItem todoListItem, @NonNull TodoListItem t1) {
            return todoListItem.getTitle().equals(t1.getTitle()) &&
                    todoListItem.getDescription().equals(t1.getDescription()) &&
                    todoListItem.getDueDate().equals(t1.getDueDate()) &&
                    todoListItem.getPriority() == t1.getPriority();
        }
    };

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder viewHolder, int i) {
        TodoListItem item = getItem(i);

        viewHolder.title.setText(item.getTitle());
        viewHolder.description.setText(item.getDescription());
        viewHolder.dueDate.setText(item.getDueDate());
        viewHolder.priority.setText(String.valueOf(item.getPriority()));
    }

    public TodoListItem getNodeAt(int position) { return getItem(position); }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private TextView dueDate;
        private TextView priority;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.text_view_title);
            description = view.findViewById(R.id.text_view_description);
            dueDate = view.findViewById(R.id.text_view_due_date);
            priority = view.findViewById(R.id.text_view_priority);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(TodoListItem item);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
