package com.resul.todoapp.sprint.dto.response;

import com.resul.todoapp.sprint.entity.Sprint;


import java.time.LocalDate;

public class TaskResponse {
    private String taskName;
    private String taskDescription;
    private LocalDate issueDate;
    private int importance;
    private int difficulty;
    private boolean isDone;


    public TaskResponse(String taskName, String taskDescription, LocalDate issueDate, int importance, int difficulty, boolean isDone) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.issueDate = issueDate;
        this.importance = importance;
        this.difficulty = difficulty;
        this.isDone = isDone;
    }

    public TaskResponse() {}

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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }


}
