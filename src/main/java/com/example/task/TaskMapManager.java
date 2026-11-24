package com.example.task;
import java.util.*;

public class TaskMapManager {
    private final Map<Integer,Task> taskMap = new HashMap<>();
    public void addTask(Task task){
        taskMap.put(task.getId(),task);
    }
    public Task getTaskById(int id){
        return taskMap.get(id);
    }
    public boolean containsTask(int id){
        return taskMap.containsKey(id);
    }
    public void removeTaskById(int id){
        taskMap.remove(id);
    }
    public int size(){
        return taskMap.size();
    }
    public boolean isEmpty(){
        return taskMap.isEmpty();
    }

}
