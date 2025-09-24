package com.resul.todoapp.routine.dto.request;

public record UpdateRoutineYearlyRequest(

        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone


) {}