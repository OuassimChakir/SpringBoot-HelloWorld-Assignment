package com.example.taskmanagament.Controllers;

import com.example.taskmanagament.Models.Task;
import com.example.taskmanagament.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id) {
        return taskService.getTask(id);
    }

    @PostMapping("/store")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable long id) {
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
    }

    @DeleteMapping("destroy/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
    }
}
