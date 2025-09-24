package com.resul.todoapp.routine.dto.response;

public record RoutineYearlyResponse(
        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone
) {}