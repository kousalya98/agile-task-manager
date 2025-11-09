package com.Backend.BackendApplication.Service.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Backend.BackendApplication.Model.Task;
import com.Backend.BackendApplication.Repo.TaskRepository;
import com.Backend.BackendApplication.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repo;

    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        if (task.getStatus() == null) task.setStatus("TODO");
        return repo.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return repo.findById(id).map(existing -> {
            existing.setTitle(task.getTitle());
            existing.setDescription(task.getDescription());
            existing.setStatus(task.getStatus());
            existing.setAssignedTo(task.getAssignedTo());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
