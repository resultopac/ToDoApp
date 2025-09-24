package com.resul.todoapp.sprint.dto.request;

import com.resul.todoapp.sprint.entity.Task;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CreateSprintRequest(
    @NotNull(message = "Sprint name can'g be null.")
    String sprintName,
    String sprintDescription,
    @NotNull(message = "Starting date can't be null.") @FutureOrPresent(message = "Starting date can't be a past date.")
    LocalDate startDate,
    @NotNull(message = "Ending date can't be null.") @Future(message = "The end date should be a future date.")
    LocalDate endDate
) {}
