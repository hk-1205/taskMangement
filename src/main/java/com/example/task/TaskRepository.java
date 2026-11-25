package com.example.task;
import java.util.List;


public interface TaskRepository {
    void save(Task task);
    Task findById(int id);
    void  deleteById(int id);
    List<Task> findAll();
}
