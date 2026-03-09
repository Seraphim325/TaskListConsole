package com.seraphim.tasklist.service;

import com.seraphim.tasklist.model.Task;
import com.seraphim.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(String title, String description) {
        taskRepository.save(title, description);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public boolean markAsCompleted(int id) {
        return taskRepository.markAsCompleted(id);
    }

    public boolean deleteTask(int id) {
        return taskRepository.deleteById(id);
    }
}
