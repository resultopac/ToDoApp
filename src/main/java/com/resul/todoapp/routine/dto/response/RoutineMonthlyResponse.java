package com.resul.todoapp.routine.dto.response;

public record RoutineMonthlyResponse(
        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone
) {}