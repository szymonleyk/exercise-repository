package com.exercises.exerciserepository.tasks;

import java.util.List;

public interface TaskRepository {
    void add(Task task);

    List<Task> fetchAll();

    Task fetchById(Long id);

    void deleteById(Long id);

    void updateTask(Long id, String title, String description);
}
