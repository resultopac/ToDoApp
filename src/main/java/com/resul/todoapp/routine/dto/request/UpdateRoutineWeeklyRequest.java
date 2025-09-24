package com.resul.todoapp.routine.dto.request;

public record UpdateRoutineWeeklyRequest(

        String routineName,
        String routineDescription,
        Double importance,
        boolean isDone

) {}