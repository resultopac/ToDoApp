package com.resul.todoapp.routine.dto.response;

public record RoutineDailyResponse(
        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone
) {}