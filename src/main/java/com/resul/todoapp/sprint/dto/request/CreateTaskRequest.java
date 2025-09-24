package com.resul.todoapp.sprint.dto.request;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateTaskRequest(
        @NotNull
        String taskName,
        String taskDescription,
        @NotNull @FutureOrPresent
        LocalDate issueDate,
        @NotNull
        int importance,
        @NotNull
        int difficulty,
        boolean isDone
) { }
