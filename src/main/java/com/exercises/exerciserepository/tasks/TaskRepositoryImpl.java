package com.exercises.exerciserepository.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskCrudRepository repository;

    @Autowired
    public TaskRepositoryImpl(TaskCrudRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Task task) {
        repository.save(task);
    }

    @Override
    public List<Task> fetchAll() {
        return repository.findAll();
    }

    @Override
    public Task fetchById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateTask(Long id, String title, String description) {
        repository.updateTask(id, title, description);
    }

}
