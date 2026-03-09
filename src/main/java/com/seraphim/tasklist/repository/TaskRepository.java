package com.seraphim.tasklist.repository;

import com.seraphim.tasklist.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    Optional<Task> findById(int id);

    List<Task> findAll();

    boolean deleteById(int id);

}
