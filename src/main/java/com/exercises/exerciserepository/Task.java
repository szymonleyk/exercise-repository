package com.exercises.exerciserepository;

import java.util.Collection;
import java.util.HashSet;

public class Task {
    private long taskId;
    private String title;
    private String description;
    private Collection<Tag> tags;

    public Task(long taskId, String title, String description, Collection<Tag> tags) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    private void addTag(Tag tag){
        if (tags == null){
            tags = new HashSet<>();
        }
        tags.add(tag);
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
