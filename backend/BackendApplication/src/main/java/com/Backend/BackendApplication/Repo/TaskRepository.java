package com.Backend.BackendApplication.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.BackendApplication.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // you can add custom queries here later
}
