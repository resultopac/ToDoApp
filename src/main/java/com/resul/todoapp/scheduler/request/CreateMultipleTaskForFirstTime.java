package com.resul.todoapp.scheduler.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateMultipleTaskForFirstTime {
    @JsonProperty("sprintInfo")
    private String sprintInfo;

    @JsonProperty("userContent")
    private String userContent;

    @JsonProperty("taskInfos")
    private String taskInfos;

    public CreateMultipleTaskForFirstTime() {}

    public CreateMultipleTaskForFirstTime(String sprintInfo, String userContent, String taskInfos) {
        this.sprintInfo = sprintInfo;
        this.userContent = userContent;
        this.taskInfos = taskInfos;
    }

    public String getTaskInfos() {
        return taskInfos;
    }

    public void setTaskInfos(String taskInfos) {
        this.taskInfos = taskInfos;
    }

    public String getSprintInfo() {
        return sprintInfo;
    }

    public void setSprintInfo(String sprintInfo) {
        this.sprintInfo = sprintInfo;
    }

    public String getUserContent() {
        return userContent;
    }

    public void setUserContent(String userContent) {
        this.userContent = userContent;
    }
}
