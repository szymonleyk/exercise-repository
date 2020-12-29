package com.exercises.exerciserepository;

import com.exercises.exerciserepository.tasks.Task;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    @Column(name = "name")
    private String tagName;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private Collection<Task> tasks = new HashSet<>();

    public Tag() {
    }

    public Tag(String name) {
        this.tagName = name;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}