package com.example.taskmanagament.Repositories;

import com.example.taskmanagament.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
