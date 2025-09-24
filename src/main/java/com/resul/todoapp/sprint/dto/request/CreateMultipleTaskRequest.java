package com.resul.todoapp.sprint.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateMultipleTaskRequest(
        @NotNull
        List<CreateTaskRequest> tasks
) {
}
