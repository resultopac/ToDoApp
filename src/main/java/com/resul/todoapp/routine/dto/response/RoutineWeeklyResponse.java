package com.resul.todoapp.routine.dto.response;

public record RoutineWeeklyResponse(
        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone
) {}