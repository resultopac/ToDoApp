package com.resul.todoapp.routine.dto.request;

public record UpdateRoutineDailyRequest(

        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone


) {}