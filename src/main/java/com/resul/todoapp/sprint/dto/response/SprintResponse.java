package com.resul.todoapp.sprint.dto.response;

import com.resul.todoapp.sprint.entity.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SprintResponse {
    private String sprintName;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks = new ArrayList<>();

    public SprintResponse(String sprintName, LocalDate startDate, LocalDate endDate, List<Task> tasks) {
        this.sprintName = sprintName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }

    public SprintResponse(){};


    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
