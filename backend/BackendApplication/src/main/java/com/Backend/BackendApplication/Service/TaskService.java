package com.Backend.BackendApplication.Service;

import java.util.List;
import java.util.Optional;

import com.Backend.BackendApplication.Model.Task;

public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
