package com.example.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMapManagerTest {
    @Test
    public void testAddTask(){
        TaskMapManager tasktest = new TaskMapManager();
        Task task = new Task(101, "get msg from udyan");
        tasktest.addTask(task);

        assertTrue(tasktest.containsTask(101));
        assertEquals(1,tasktest.size());
    }
    @Test
    public void testGetTaskById(){
        TaskMapManager  tasktest = new TaskMapManager();
        Task task = new Task(101,"learn hashmap");
        tasktest.addTask(task);
        assertEquals(task,tasktest.getTaskById(101));
    }
    @Test
    public void testGetTaskByIdNotFound(){
        TaskMapManager tasktest = new TaskMapManager();
        assertNull(tasktest.getTaskById(101));
    }
    @Test
    public void testContainsTask() {
        TaskMapManager tasktest = new TaskMapManager();
        Task task = new Task(101, "learn hashmap");
        tasktest.addTask(task);
        assertTrue(tasktest.containsTask(101));
        assertFalse(tasktest.containsTask(102));
    }
    @Test
    public void testRemoveTaskById() {
        TaskMapManager tasktest = new TaskMapManager();
        Task task = new Task(101, "learn hashmap");
        tasktest.addTask(task);
        tasktest.removeTaskById(101);
        assertFalse(tasktest.containsTask(101));
        assertEquals(0, tasktest.size());
    }
    @Test
    public void testIsEmpty() {
        TaskMapManager tasktest = new TaskMapManager();
        assertTrue(tasktest.isEmpty());
        Task task = new Task(101, "learn hashmap");
        tasktest.addTask(task);
        assertFalse(tasktest.isEmpty());
    }
    @Test
    public void testDuplicateTaskId() {
        TaskMapManager tasktest = new TaskMapManager();
        Task task1 = new Task(101, "learn hashmap");
        Task task2 = new Task(101, "learn hashmap again");
        tasktest.addTask(task1);
        tasktest.addTask(task2);
        assertEquals(1, tasktest.size());
        assertEquals(task2, tasktest.getTaskById(101));
    }



}
