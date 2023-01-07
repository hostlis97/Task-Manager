package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private final int MAXTASK = 7;
    private List<String> taskList = new ArrayList<>();

    public void addTask(String task) {
        if (taskList.size() < MAXTASK) {
            taskList.add(task);
        }
    }

    public void removeTask(String task) {
        taskList.remove(task);
    }

    public String getAllTasks() {
        if (taskList.size() > 0) {
            String sorttask="";
            Collections.sort(taskList);
            for (String task : taskList) {
                sorttask += task + " ";
            }
            return sorttask;
        }
        return "Список задач пуст!";
    }

}
