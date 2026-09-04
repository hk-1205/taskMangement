package com.example.task;

public class Task {

    private final int id;
    private final String title;
    private boolean completed;

    public Task(int id, String title) throws IllegalArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if(id<0||id==0){
            throw new IllegalArgumentException("ID cannot be negative or zero");
        }
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }
}

