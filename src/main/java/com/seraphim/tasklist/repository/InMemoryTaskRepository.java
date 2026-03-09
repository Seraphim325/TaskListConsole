package com.seraphim.tasklist.repository;

import com.seraphim.tasklist.model.Task;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.List;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    private Map<Integer, Task> database;
    private static int currentId = 1;

    public Task save(Task task) {
        return null;
    }

    public Optional<Task> findById(int id) {
        return Optional.empty();
    }

    public List<Task> findAll() {
        return null;
    }

    public boolean deleteById(int id) {
        return false;
    }
}
