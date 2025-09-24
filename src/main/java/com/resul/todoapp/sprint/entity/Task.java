package com.resul.todoapp.sprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_description")
    private String taskDescription;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "importance")
    private int importance;
    @Column(name = "difficulty")
    private int difficulty;
    @Column
    private boolean isDone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sprint_id")
    @JsonIgnore
    private Sprint sprint;

    public Task(int id, String taskName, String taskDescription, LocalDate issueDate, int importance, int difficulty,boolean isDone, Sprint sprint) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.issueDate = issueDate;
        this.importance = importance;
        this.difficulty = difficulty;
        this.isDone = isDone;
        this.sprint = sprint;
    }

    public Task() {}

    public String getTaskInfo(){
        String taskInfo = "Task Adı:" + this.taskName;
        taskInfo += "\n Task açıklaması:" + this.taskDescription;
        taskInfo += "\n Task Önemi 1-10:" + this.importance;
        taskInfo += "\n Task Zorluğu 1-10:" + this.difficulty;
        taskInfo += "\n Task'ın ait olduğu sprint:" + this.sprint.getSprintName();
        taskInfo += "\n Task tamamlandı mı:" + this.isDone;
        return taskInfo;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
}
