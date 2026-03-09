package com.seraphim.tasklist.model;

public class Task implements Comparable<Task> {
    private int id;

    private String title;

    private String description;

    private boolean isCompleted;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        isCompleted = false;
    }

    public void complete() {
        isCompleted = true;
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "ID: " + id + " Title: " + title + " Description: " + description + " Completed: " + (isCompleted ? "+" : "-") + "\n" ;
    }

}
