package com.exercises.exerciserepository.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTask(Long id) {
        return taskRepository.fetchById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.fetchAll();
    }

    public List<Task> getTasksByTagName(String tagName) {
        List<Task> resListTasks = new ArrayList<>();
        for (Task task : taskRepository.fetchAll()) {
            if (task.getTags().stream().anyMatch(tag -> tag.getTagName().matches(tagName))) {
                resListTasks.add(task);
            }
        }
        return resListTasks;
    }

    public void addNewTask(Task task) {
        taskRepository.add(task);
    }

    public void update(long id, Task updateTask) {
        taskRepository.updateTask(id, updateTask.getTitle(), updateTask.getDescription());
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
