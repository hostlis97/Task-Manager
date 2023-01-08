package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    private int port;
    private Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Starting server at " + port + "...");
            while (true) {
                try (Socket client = server.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    String inRead = reader.readLine();
                    Task task = gson.fromJson(inRead, Task.class);
                    switch (task.getType()) {
                        case "ADD":
                            todos.addTask(task.getTask());
                            System.out.println(todos.getAllTasks());
                            writer.println(todos.getAllTasks());
                            continue;
                        case "REMOVE":
                            todos.removeTask(task.getTask());
                            System.out.println(todos.getAllTasks());
                            writer.println(todos.getAllTasks());
                            continue;
                        default:
                            System.out.println("Неверно указан атрибут Type!");
                            writer.println("Неверно указан атрибут Type!");
                    }


                }
            }
        }
    }
}