package com.resul.todoapp.sprint.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "sprint_name", unique = true)
    private String sprintName;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @JsonIgnore
    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();

    public Sprint(int id, String sprintName, LocalDate startDate, LocalDate endDate, List<Task> tasks) {
        this.id = id;
        this.sprintName = sprintName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }

    public Sprint() {};

    public String getSprintInfo(){
        String sprintInfo = "Sprint Adı:" +  this.sprintName;
        sprintInfo += "\nSprint Başlangıç Tarihi: " + this.startDate;
        sprintInfo += "\nSprint Bitiş Tarihi: " + this.endDate;
        return sprintInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
