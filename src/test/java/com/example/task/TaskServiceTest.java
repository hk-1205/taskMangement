
package com.example.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        TaskRepository repository = new InMemoryTaskRepository();
        taskService = new TaskService(repository);
    }

    @Test
    void shouldAddTask() {
        Task task = new Task(1, "Learn Spring");

        taskService.addTask(task);

        assertEquals(task, taskService.getTaskById(1));
    }

    @Test
    void shouldGetTaskById() {
        Task task = new Task(2, "Learn Java");

        taskService.addTask(task);

        Task result = taskService.getTaskById(2);

        assertEquals(2, result.getId());
        assertEquals("Learn Java", result.getTitle());
    }

    @Test
    void shouldThrowExceptionWhenTaskDoesNotExist() {
        assertThrows(
                TaskNotFoundException.class,
                () -> taskService.getTaskById(100)
        );
    }

    @Test
    void shouldGetAllTasks() {
        Task task1 = new Task(1, "Learn Java");
        Task task2 = new Task(2, "Learn Spring");

        taskService.addTask(task1);
        taskService.addTask(task2);

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(2, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
    }

    @Test
    void shouldDeleteTask() {
        Task task = new Task(1, "Learn Java");

        taskService.addTask(task);
        taskService.deleteTask(1);

        assertThrows(
                TaskNotFoundException.class,
                () -> taskService.getTaskById(1)
        );
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistingTask() {
        assertThrows(
                TaskNotFoundException.class,
                () -> taskService.deleteTask(100)
        );
    }
}

