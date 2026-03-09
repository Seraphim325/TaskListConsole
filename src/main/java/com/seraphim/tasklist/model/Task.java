package com.seraphim.tasklist.model;

public class Task {
    private int id;

    private String title;

    private String description;

    private boolean isReady;

    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        isReady = false;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public boolean isReady() {
        return isReady;
    }


}
