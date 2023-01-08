package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;


public class Todos {
    private final int MAX_TASK = 7;
    private TreeSet<String> taskList = new TreeSet<>();

    public void addTask(String task) {
        if (taskList.size() < MAX_TASK) {
            taskList.add(task);
        }
    }

    public void removeTask(String task) {
        taskList.remove(task);
    }

    public String getAllTasks() {
        if (taskList.isEmpty()) {
            return "Список задач пуст!";
        } else {
            StringBuilder sorttask = new StringBuilder();
            for (String task : taskList) {
                sorttask.append(task);
                sorttask.append(" ");
            }
            return sorttask.toString();
        }
    }

}
