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

    public void createTask() {
        
    }

    public List<Task> getAllTasks() {
        return null;
    }

    public boolean markAsCompleted(int id) {
        return false;
    }

    public boolean deleteTask(int id) {
        return false;
    }
}
