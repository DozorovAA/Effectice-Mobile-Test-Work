package ru.test.EffectiveMobileTestWork.model.task;

import jakarta.persistence.*;
import ru.test.EffectiveMobileTestWork.model.user.User;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Priority priority;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
    @Column(name = "executor_Id")
    private String executorId;
    private String comment;
    public void apply(TaskPatch taskPatch){
        if(taskPatch.getDescription() != null) setDescription(taskPatch.getDescription());
        if(taskPatch.getStatus() != null)      setStatus(taskPatch.getStatus());
        if(taskPatch.getPriority() != null)    setPriority(taskPatch.getPriority());
        if(taskPatch.getTitle() != null)       setTitle(taskPatch.getTitle());
        if(taskPatch.getComment() != null)     setComment(taskPatch.getComment());
        if(taskPatch.getAuthor() != null)      setAuthor(taskPatch.getAuthor());
        if(taskPatch.getExecutorId() != null)  setExecutor(taskPatch.getExecutorId());
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getExecutor() {
        return executorId;
    }

    public void setExecutor(String executor) {
        this.executorId = executorId;
    }
}
