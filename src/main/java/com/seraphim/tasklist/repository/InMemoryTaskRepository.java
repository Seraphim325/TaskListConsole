package com.seraphim.tasklist.repository;

import com.seraphim.tasklist.model.Task;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.*;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private final Map<Integer, Task> database;
    private static int currentId = 1;

    public InMemoryTaskRepository() {
        database = new HashMap<>();
    }

    public Task save(String title, String description) {
        Task task = new Task(currentId, title, description);
        database.put(currentId, task);
        currentId++;
        return task;
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();

        for (Map.Entry<Integer,Task> entry: database.entrySet()) {
            tasks.add(entry.getValue());
        }

        return tasks;
    }

    public boolean deleteById(int id) {
        Optional<Task> task = Optional.ofNullable(database.get(id));
        if (task.isEmpty()) return false;

        database.remove(id);
        return true;
    }

    public boolean markAsCompleted(int id) {
        Optional<Task> task = Optional.ofNullable(database.get(id));
        if (task.isEmpty()) return false;

        task.get().complete();
        return true;
    }
}
