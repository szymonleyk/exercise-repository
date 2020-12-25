package com.exercises.exerciserepository.tasks;

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

    public List<Task> getAllTasks() {
        return taskRepository.fetchAll();
    }

    public void addNewTask(Task task) {
        taskRepository.add(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task getTask(Long id){
        return taskRepository.fetchById(id);
    }

    public void update(long id, Task updateTask) {
        taskRepository.updateTask(id, updateTask.getTitle(), updateTask.getDescription());
    }
}
