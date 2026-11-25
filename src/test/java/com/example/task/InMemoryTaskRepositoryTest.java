
package com.example.task;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryTaskRepositoryTest {

    @Test
    public void saveTask() {
        InMemoryTaskRepository taskRepository = new InMemoryTaskRepository();
        Task task = new Task(1, "Test Task");

        taskRepository.save(task);

        assertEquals(task, taskRepository.findById(1));
    }

    @Test
    public void findByIdReturnsTask() {
        InMemoryTaskRepository taskRepository = new InMemoryTaskRepository();
        Task task = new Task(1, "Test Task");

        taskRepository.save(task);

        assertNotNull(taskRepository.findById(1));
        assertEquals(task, taskRepository.findById(1));
    }

    @Test
    public void findByIdReturnsNullWhenTaskDoesNotExist() {
        InMemoryTaskRepository taskRepository = new InMemoryTaskRepository();

        assertNull(taskRepository.findById(1));
    }

    @Test
    public void deleteByIdRemovesTask() {
        InMemoryTaskRepository taskRepository = new InMemoryTaskRepository();
        Task task = new Task(1, "Test Task");
        taskRepository.save(task);

        taskRepository.deleteById(1);

        assertNull(taskRepository.findById(1));
        assertEquals(0, taskRepository.findAll().size());
    }

    @Test
    public void findAllReturnsAllTasks() {
        InMemoryTaskRepository taskRepository = new InMemoryTaskRepository();

        Task task1 = new Task(1, "Test Task 1");
        Task task2 = new Task(2, "Test Task 2");
        Task task3 = new Task(3, "Test Task 3");

        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task3);

        List<Task> tasks = taskRepository.findAll();

        assertEquals(3, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
        assertTrue(tasks.contains(task3));
    }

    @Test
    public void saveTaskWithSameIdReplacesPreviousTask() {
        InMemoryTaskRepository taskRepository = new InMemoryTaskRepository();

        Task task1 = new Task(1, "Test Task 1");
        Task task2 = new Task(1, "Test Task 2");

        taskRepository.save(task1);
        taskRepository.save(task2);

        assertEquals(task2, taskRepository.findById(1));
        assertEquals(1, taskRepository.findAll().size());
    }
}

