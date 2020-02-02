package ru.volkov.webApp.KanbanBoard.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table (name = "task")
public class Task implements Serializable {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @ManyToOne
    @JoinColumn
    private KanbanUser kanbanUser;

    @ManyToOne
    @JoinColumn
    private Project project;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTask;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime deadTask;

    private boolean finished;

    @Enumerated(EnumType.STRING)
    @Column(name = "stage")
    private ProjectStage stage;

    @Enumerated(EnumType.STRING)
    @Column(name = "importance")
    private TaskImportance importance;

    public Task() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartTask() {
        return startTask;
    }

    public void setStartTask(LocalDateTime startTask) {
        this.startTask = startTask;
    }

    public LocalDateTime getDeadTask() {
        return deadTask;
    }

    public void setDeadTask(LocalDateTime deadTask) {
        this.deadTask = deadTask;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public KanbanUser getKanbanUser() {
        return kanbanUser;
    }

    public void setKanbanUser(KanbanUser kanbanUser) {
        this.kanbanUser = kanbanUser;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ProjectStage getStage() {
        return stage;
    }

    public void setStage(ProjectStage stage) {
        this.stage = stage;
    }

    public TaskImportance getImportance() {
        return importance;
    }

    public void setImportance(TaskImportance importance) {
        this.importance = importance;
    }
}
