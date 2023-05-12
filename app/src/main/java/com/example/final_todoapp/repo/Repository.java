package com.example.final_todoapp.repo;

import androidx.lifecycle.LiveData;

import com.example.final_todoapp.database.AppDatabase;
import com.example.final_todoapp.database.TaskDao;
import com.example.final_todoapp.model.Task;

import java.util.List;

public class Repository {

    TaskDao dao;

    public Repository(AppDatabase appDatabase){
        dao = appDatabase.taskDao();
    }

    public LiveData<List<Task>> getTasks(){
        return dao.loadAllTasks();
    }

    public LiveData<Task> getTaskById(int taskId){
        return dao.loadTAskById(taskId);
    }

    public void updateTask(final Task task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(task);
            }
        });
    }

    public void deleteTask(final Task task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.deleteTask(task);
            }
        });
    }

    public  void  insertTask(final Task task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertTask(task);
            }
        });
    }
}