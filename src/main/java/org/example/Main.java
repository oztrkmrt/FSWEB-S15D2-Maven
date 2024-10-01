package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("alfa", "Fix","Ann",Status.IN_PROGRESS, Priority.MED);
        Task task2 = new Task("beta","develop","Bob",Status.ASSIGNED,Priority.HIGH);
        Task task3 = new Task("gamma", "tests","Carol",Status.IN_QUEUE,Priority.MED);
        Task task4 = new Task("delta","deploy",null,Status.IN_QUEUE,Priority.LOW);
        Task task5 = new Task("alfa","Fix","Bob",Status.IN_PROGRESS,Priority.MED);

        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(task1);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task2);
        bobsTasks.add(task5);

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(task3);

        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(task4);

        TaskData taskData = new TaskData(annsTasks,bobsTasks,carolsTasks,unassignedTasks);


        System.out.println("All tasks: " + taskData.getTasks("all"));
        System.out.println("Bob's tasks: " + taskData.getTasks("bob"));
        System.out.println("Unassigned tasks: " + taskData.getDifferences(unassignedTasks, taskData.getTasks("ann")));
        System.out.println(taskData.getIntersection(annsTasks,bobsTasks));

        StringSet.findUniqueWords();
    }
}