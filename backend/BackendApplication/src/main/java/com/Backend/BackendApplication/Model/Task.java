package com.Backend.BackendApplication.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@lombok
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String status; // TODO, IN_PROGRESS, DONE

    private String assignedTo;

    private LocalDateTime createdAt;

    public Task() {
        this.createdAt = LocalDateTime.now();
    }

}
