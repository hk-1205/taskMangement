package com.example.task;
import java.util.*;


public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
    public Task getTask(int index){
        return tasks.get(index);
    }
    public void printAllTasks(){
        for(Task task :tasks){
            System.out.println("Task ID: " + task.getId() + ", Title: " + task.getTitle());
        }
    }
    public void removeTaskByIndex(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + tasks.size());
        }
        tasks.remove(index);
    }
}
