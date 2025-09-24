package com.resul.todoapp.sprint.dto.request;

import com.resul.todoapp.sprint.entity.Sprint;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String taskName,
        String taskDescription,
        LocalDate issueDate,
        int importance,
        int difficulty,
        boolean isDone
) { }
