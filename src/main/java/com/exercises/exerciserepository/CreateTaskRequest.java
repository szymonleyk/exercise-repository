package com.exercises.exerciserepository;

import java.util.Collection;

public class CreateTaskRequest {
    private String taskId;
    private String title;
    private String description;
    private Collection<String> tags;

    public CreateTaskRequest(String taskId, String title, String description, Collection<String> tags) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public void setTags(Collection<String> tags) {
        this.tags = tags;
    }
}
