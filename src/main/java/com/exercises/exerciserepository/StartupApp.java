package com.exercises.exerciserepository;

import com.exercises.exerciserepository.tasks.Task;
import com.exercises.exerciserepository.tasks.TaskRepositoryImpl;
import com.exercises.exerciserepository.tasks.TaskService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class StartupApp {

    private final TaskRepositoryImpl repository;
    private final TaskService service;

    public StartupApp(TaskRepositoryImpl repository, TaskService service) {
        this.repository = repository;
        this.service = service;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initializeApp() {
        testAddNewTask();
        testGetTask();
        testGetAllTasks();
        testGetTasksByTagName("ifi");
        testChangeTaskValues();
        testDeleteTask();
    }

    private void testGetTasksByTagName(String tagName) {
        List<Task> tasksByTagName = service.getTasksByTagName(tagName);
        if (!tasksByTagName.isEmpty()) {
            System.out.println("Znaleziono zadanie z tagiem if. Ilość zadań " + tasksByTagName.size());
        } else {
            System.out.println("Nie znaleziono otagowanego zadania");
        }
    }

    private void testAddNewTask() {
        Collection<Tag> testTags = insertTestTag();
        Task task = new Task(1L, "Testowe zadanie", "Zadanie utworzone dla testu numer 1", testTags);
        service.addNewTask(task);
    }

    private Collection<Tag> insertTestTag() {
        String[] tagsData = {"instrukcja warunkowa", "if"};
        Collection<Tag> tags = new HashSet<>();
        for (String tag : tagsData) {
            tags.add(new Tag(tag));
        }
        return tags;
    }

    private void testGetAllTasks() {
        System.out.println("Liczba zadań znajdujących się w bazie " + service.getAllTasks().size());
    }


    private void testGetTask() {
        if (service.getTask(1L).getTitle().contains("Testowe zadanie")) {
            System.out.println("Testowe zadanie znajduje się w bazie danych");

        } else {
            System.out.println("Testowe zadanie nie znajduje się w bazie danych");
        }
    }

    @Transactional
    void testChangeTaskValues() {
        System.out.println("Tytuł zadanie przed zmianą: " + service.getTask(1L).getTitle());
        Task taskWithUpdateValues = new Task("Nowy tytuł", "Nowy opis");
        service.update(1L, taskWithUpdateValues);
        if (service.getTask(1L).getTitle().contains("Nowy tytuł")) {
            System.out.println("Informacje o zadaniu zostały zaaktualizowane");
        } else {
            System.out.println("Informacje o zadaniu nie zostały zaaktualizowane");
        }
    }

    private void testDeleteTask() {
        if (service.getAllTasks().size() > 0) {
            String taskTitleBeforeDelete = service.getTask(1L).getTitle();
            service.deleteTask(1L);
            System.out.println("Usunięto zadnie o tytule: " + taskTitleBeforeDelete);
        } else {
            System.out.println("Brak zadań w bazie danych");
        }
    }
}
