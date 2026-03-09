package com.seraphim.tasklist.console;

import com.seraphim.tasklist.model.Task;
import com.seraphim.tasklist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final Scanner scanner;
    private final TaskService service;

    @Autowired
    public ConsoleUI(TaskService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void consoleMenu() {
        while (true) {
            UI();
            int choice = readChoice();
            callMethod(choice);
        }
    }

    private void UI() {
        System.out.println("--------Task List--------");
        System.out.println("1.Add task");
        System.out.println("2.Show all tasks");
        System.out.println("3.Mark task as done");
        System.out.println("4.Delete task");
        System.out.println("5.Exit");
    }

    private int readChoice() {
        int choice;
        while (true) {
            System.out.println("Enter number of task: ");
            try {
                choice = scanner.nextInt();

                if (choice < 1 || choice > 5) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Try again.");
                scanner.nextLine();
                continue;
            }
            break;
        }
        return choice;
    }

    private void callMethod(int choice) {
        switch (choice) {
            case 1 -> createTask();
            case 2 -> printAllTasks();
            case 3 -> markAsCompleted();
            case 4 -> deleteById();
            case 5 -> {
                scanner.close();
                System.exit(0);
            }
        }
    }

    private void createTask() {
        scanner.nextLine();
        System.out.println("Write title: ");
        String title = scanner.nextLine();

        System.out.println("Write description: ");
        String description = scanner.nextLine();

        service.createTask(title, description);
    }

    private void printAllTasks() {
        List<Task> list = service.getAllTasks();
        Collections.sort(list);
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        for (Task task: list) {
            System.out.println(task);
        }
    }

    private void markAsCompleted() {
        while (true) {
            System.out.println("Enter id: ");
            try {
                int id = scanner.nextInt();
                if (!service.markAsCompleted(id)) throw new InputMismatchException();

            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Try again.");
                scanner.nextLine();
                continue;
            }
            break;
        }
    }

    private void deleteById() {
        while (true) {
            System.out.println("Enter id:");
            try {
                int id = scanner.nextInt();
                if (!service.deleteTask(id)) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Try again.");
                scanner.nextLine();
                continue;
            }
            break;
        }
    }
}
