package com.example.taskmanagament.Services;

import com.example.taskmanagament.Models.Task;
import com.example.taskmanagament.Repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(long id, Task task){
        Task taskToUpdate = taskRepository.findById(id).get();
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDescription(task.getDescription());
        taskToUpdate.setCompleted(task.isCompleted());
        return taskRepository.save(taskToUpdate);
    }

    public void deleteTask(long id){
        taskRepository.deleteById(id);
    }

    public Task getTask(long id) {
        return taskRepository.findById(id).get();
    }
}
