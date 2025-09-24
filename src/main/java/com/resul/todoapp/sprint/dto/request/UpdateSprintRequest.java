package com.resul.todoapp.sprint.dto.request;

import com.resul.todoapp.sprint.entity.Task;

import java.time.LocalDate;
import java.util.List;

public record UpdateSprintRequest(
    String sprintName,
    String sprintDescription,
    LocalDate startDate,
    LocalDate endDate

){ }
