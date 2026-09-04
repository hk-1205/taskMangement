package com.example.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {

        Task myTask = new Task(1, "Test Task");

        assertEquals(1, myTask.getId());
        assertEquals("Test Task", myTask.getTitle());
        assertFalse(myTask.isCompleted());
    }

    @Test
    public void testTaskCompletion() {

        Task myTask = new Task(2, "Another Task");

        myTask.complete();

        assertTrue(myTask.isCompleted());
    }
    @Test
    public void testTaskCompletionStatus() {

        Task myTask = new Task(3, "Third Task");

        assertTrue(myTask.isCompleted());

        myTask.complete();

        assertTrue(myTask.isCompleted());
    }
}
