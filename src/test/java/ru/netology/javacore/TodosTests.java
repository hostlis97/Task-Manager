package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {

    Todos todos = new Todos();
    Task task = new Task();

    @BeforeEach
    void setUp() {
        String jsonText = "{ \"type\": \"ADD\", \"task\": \"Играть\" }";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        task = gson.fromJson(jsonText, Task.class);
    }

    @Test
    public void testAddTask() {
        todos.addTask(task.getTask());
        Assertions.assertEquals("Играть ", todos.getAllTasks());
    }

    @Test
    public void testRemoveTask() {
        todos.addTask("Погулять");
        todos.addTask("Работать");
        todos.addTask("Учится");
        todos.removeTask("Работать");
        Assertions.assertEquals("Погулять Учится ", todos.getAllTasks());
    }

    @Test
    public void testGetAllTasks() {
        todos.addTask("Погулять");
        todos.addTask("Работать");
        todos.addTask("Учится");
        Assertions.assertEquals("Погулять Работать Учится ", todos.getAllTasks());
    }
}