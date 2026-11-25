package com.example.task;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class InMemoryTaskRepository implements TaskRepository {
    private final Map<Integer, Task> taskMap = new HashMap<>();;

    @Override
    public void save(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public Task findById(int id) {
        return taskMap.get(id);
    }

    @Override
    public void deleteById(int id) {
        taskMap.remove(id);
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(taskMap.values());
    }
}
