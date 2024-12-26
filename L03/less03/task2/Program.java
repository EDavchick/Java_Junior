package org.dav.less03.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.dav.less03.task2.ToDoListApp.*;

public class Program {
    /**
     * Разработать TO DO лист, где мы будем создавать задачи
     * У каждой задачи будут состояния: выполнено и не выполнено
     * Приложение должно сохранять состояние задач, которые мы создали
     */

    public static void main(String[] args) {
        List<ToDo> tasks;

        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            tasks = loadTasksFromFile(FILE_JSON);
        else
            tasks = prepairTasks();
        ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
        ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
        ToDoListApp.saveTasksToFile(FILE_XML, tasks);

        displayTasks(tasks);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Choose action:");
            System.out.println("1. Add new task");
            System.out.println("2. Mark task as completed");
            System.out.println("3. Exit");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    ToDoListApp.addNewTask(scanner, tasks);
                    break;
                case "2":
                    ToDoListApp.markTaskAsDone(scanner, tasks);
                    break;
                case "3":
                    ToDoListApp.saveTasksToFile(FILE_JSON, tasks);
                    ToDoListApp.saveTasksToFile(FILE_BIN, tasks);
                    ToDoListApp.saveTasksToFile(FILE_XML, tasks);
                    System.out.println("Tasks list has been saved");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Incorrect choice, try again");
                    break;
            }

            displayTasks(tasks);
        }
    }

    static List<ToDo> prepairTasks(){
        ArrayList<ToDo> list = new ArrayList<>();
        list.add(new ToDo("Going to market for products"));
        list.add(new ToDo("Walk with dog"));
        list.add(new ToDo("Change a lamp"));
        return list;
    }
}
