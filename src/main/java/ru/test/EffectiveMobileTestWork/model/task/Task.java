package ru.test.EffectiveMobileTestWork.model.task;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private String comment;
    public void apply(TaskPatch taskPatch){
        if(taskPatch.getDescription() != null) setDescription(taskPatch.getDescription());
        if(taskPatch.getStatus() != null)      setStatus(taskPatch.getStatus());
        if(taskPatch.getPriority() != null)    setPriority(taskPatch.getPriority());
        if(taskPatch.getTitle() != null)       setTitle(taskPatch.getTitle());
        if(taskPatch.getComment() != null)     setComment(taskPatch.getComment());
    }
    public Task() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
