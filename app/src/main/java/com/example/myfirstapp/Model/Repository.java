package com.example.myfirstapp.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class Repository {

    private TodoListItemDao itemDao;
    private LiveData<List<TodoListItem>> allItems;

    public Repository(Application application) {
        TodoListItemDatabase database = TodoListItemDatabase.getInstance(application);
        itemDao = database.todoListItemDao();
        allItems = itemDao.getAllItems();
    }

    public void insert(TodoListItem item) {
        new InsertItemAsyncTask(itemDao).execute(item);
    }

    public void update(TodoListItem item) {
        new UpdateItemAsyncTask(itemDao).execute(item);
    }

    public void delete(TodoListItem item) {
        new DeleteItemAsyncTask(itemDao).execute(item);
    }

    public void deleteAllItems() {
        new DeleteAllItemsAsyncTask(itemDao).execute();
    }

    public LiveData<List<TodoListItem>> getAllItems() {
        return allItems;
    }

    private static class InsertItemAsyncTask extends AsyncTask<TodoListItem, Void, Void> {
        private TodoListItemDao itemDao;

        private InsertItemAsyncTask(TodoListItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(TodoListItem... todoListItems) {
            itemDao.insert(todoListItems[0]);
            return null;
        }
    }

    private static class UpdateItemAsyncTask extends AsyncTask<TodoListItem, Void, Void> {
        private TodoListItemDao itemDao;

        private UpdateItemAsyncTask(TodoListItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(TodoListItem... todoListItems) {
            itemDao.update(todoListItems[0]);
            return null;
        }
    }

    private static class DeleteItemAsyncTask extends AsyncTask<TodoListItem, Void, Void> {
        private TodoListItemDao itemDao;

        private DeleteItemAsyncTask(TodoListItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(TodoListItem... todoListItems) {
            itemDao.delete(todoListItems[0]);
            return null;
        }
    }

    private static class DeleteAllItemsAsyncTask extends AsyncTask<Void, Void, Void> {
        private TodoListItemDao itemDao;

        private DeleteAllItemsAsyncTask(TodoListItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.deleteAllItems();
            return null;
        }
    }
}
