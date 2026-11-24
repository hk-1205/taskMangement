package com.example.task;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    Task task;

    @BeforeEach
    public void setUp() {
        task = new Task(1, "Test Task");
    }

    @Test
    public void testTaskCreation() {



        assertEquals(1, task.getId());
        assertEquals("Test Task", task.getTitle());
        assertFalse(task.isCompleted());
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

        assertFalse(myTask.isCompleted());

        myTask.complete();

        assertTrue(myTask.isCompleted());
    }
    @Test
    public void testTaskCreationWithInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> new Task(-1, "Invalid Task"));
    }
    @Test
    public void testTaskCreationWithEmptyTitle(){
        assertThrows(IllegalArgumentException.class, () -> new Task(1, ""));
    }
    @Test
    public void testTaskCreationWithNullTitle(){
        assertThrows(IllegalArgumentException.class, () -> new Task(1, null));
    }
    @Test
    public void testTaskCreationWithZeroID() {
        assertThrows(IllegalArgumentException.class, () -> new Task(0, "Zero ID Task"));
    }
    @Test
    public void TaskNotFoundExceptionTest(){
        TaskNotFoundException exception = assertThrows(TaskNotFoundException.class, () -> {
            throw new TaskNotFoundException("Task not found");
        });
        assertEquals("Task not found", exception.getMessage());
    }
    @AfterEach
    public void teardown(){
        System.out.println("Test Completed");
    }
    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Starting Task Tests");

    }
    @AfterAll
    public static void afterAllTests() {
        System.out.println("All Task Tests Completed");
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testTaskCreationWithValidIDs(int id) {
        Task task = new Task(id, "Task " + id);
        assertEquals(id, task.getId());
        assertEquals("Task " + id, task.getTitle());
    }
}
