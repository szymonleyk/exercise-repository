package com.exercises.exerciserepository.tasks;

import com.exercises.exerciserepository.Tag;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String title;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "tasks_tags",
            joinColumns = {@JoinColumn(name = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Collection<Tag> tags;

    public Task() {
    }

    public Task(Long taskId, String title, String description, Collection<Tag> tags) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }
    public Task(String title, String description, Collection<Tag> tags) {
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addTag(Tag tag){
        if (tags == null){
            tags = new HashSet<>();
        }
        tags.add(tag);
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
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