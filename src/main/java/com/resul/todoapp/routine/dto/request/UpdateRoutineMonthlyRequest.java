package com.resul.todoapp.routine.dto.request;

public record UpdateRoutineMonthlyRequest(
        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone
) {}