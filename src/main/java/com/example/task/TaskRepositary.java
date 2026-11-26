
package com.example.task;

import java.util.List;

public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(Task task) {
        repository.save(task);
    }

    public Task getTaskById(int id) {
        Task task = repository.findById(id);

        if (task == null) {
            throw new TaskNotFoundException("Task not found with ID: " + id);
        }

        return task;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public void deleteTask(int id) {
        Task task = repository.findById(id);

        if (task == null) {
            throw new TaskNotFoundException("Task not found with ID: " + id);
        }

        repository.deleteById(id);
    }
}

