package com.example.final_todoapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.final_todoapp.database.AppDatabase;
import com.example.final_todoapp.model.Task;
import com.example.final_todoapp.repo.Repository;

public class AddEditTaskViewModel extends AndroidViewModel {

    Repository repository;
    LiveData<Task> task;

    AddEditTaskViewModel(Application application, int taskId){
        super(application);
        AppDatabase database = AppDatabase.getInstance(application);
        repository = new Repository(database);
        if(taskId != -1)
            task = repository.getTaskById(taskId);
    }


    public LiveData<Task> getTask(){
        return task;
    }

    public void insertTask(Task task){
        repository.insertTask(task);
    }

    public void updateTask(Task task){
        repository.insertTask(task);
    }


}
