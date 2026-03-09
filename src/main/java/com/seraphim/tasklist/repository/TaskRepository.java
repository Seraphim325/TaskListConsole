package com.seraphim.tasklist.repository;

import com.seraphim.tasklist.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(String title, String description);

    List<Task> findAll();

    boolean deleteById(int id);

    boolean markAsCompleted(int id);

}
