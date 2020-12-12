package com.exercises.exerciserepository;

import java.util.Collection;

public class TaskResponse {
    private long taskId;
    private String title;
    private String description;
    private Collection<Tag> tags;

    public TaskResponse(long taskId, String title, String description, Collection<Tag> tags) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    static TaskResponse from(Task task){
        return new TaskResponse(
                task.getTaskId(),
                task.getTitle(),
                task.getDescription(),
                task.getTags()
        );
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
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

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }
}

