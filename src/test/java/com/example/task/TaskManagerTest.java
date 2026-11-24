
package com.example.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Test Task");

        taskManager.addTask(task);

        assertTrue(taskManager.getTasks().contains(task));
        assertEquals(1, taskManager.getTasks().size());
    }

    @Test
    public void testRemoveTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Test Task");

        taskManager.addTask(task);
        taskManager.removeTask(task);

        assertFalse(taskManager.getTasks().contains(task));
        assertEquals(0, taskManager.getTasks().size());
    }

    @Test
    public void testAddMultipleTasks() {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task(1, "Learn Java");
        Task task2 = new Task(2, "Learn Collections");
        Task task3 = new Task(3, "Learn JUnit");

        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);

        assertEquals(3, taskManager.getTasks().size());
    }

    @Test
    public void testGetByIndex() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task(1, "Learn Java");
        Task task2 = new Task(2, "Learn Collections");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        assertEquals(task1, taskManager.getTask(0));
        assertEquals(task2, taskManager.getTask(1));
    }
    @Test
    public void testGetByIndexOutOfBounds() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task(1, "Learn Java");
        taskManager.addTask(task1);
        assertThrows(IndexOutOfBoundsException.class, () -> taskManager.getTask(1));
    }
    @Test
    public void testPrintAllTasks() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task(1, "Learn Java");
        Task task2 = new Task(2, "Learn Collections");
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Capture the output of printAllTasks
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        taskManager.printAllTasks();

        String expectedOutput = "Task ID: 1, Title: Learn Java" + System.lineSeparator() +
                "Task ID: 2, Title: Learn Collections" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testRemoveTaskByIndex() {
        TaskManager taskManager = new TaskManager();
        Task task1 = new Task(1, "Learn Java");
        Task task2 = new Task(2, "Learn Collections");
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        taskManager.removeTaskByIndex(0);

        assertEquals(1, taskManager.getTasks().size());
        assertEquals(task2, taskManager.getTask(0));
    }
}
