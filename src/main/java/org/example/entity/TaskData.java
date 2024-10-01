package org.example.entity;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getUnion(Set<Task>... sets){
        HashSet<Task> allTasks = new LinkedHashSet<>();
        for(Set<Task> tasks: sets){
            allTasks.addAll(tasks);
        }
        return allTasks;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2){
        Set<Task> intersectedTasks = new HashSet<>(set1);
        intersectedTasks.retainAll(set2);
        return intersectedTasks;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2){
        Set<Task> differenceTasks = new HashSet<>(set1);
        differenceTasks.removeAll(set2);
        return differenceTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(bobsTasks, annsTasks, carolsTasks);
        }
        return new HashSet<>();
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }
}
