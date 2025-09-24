package com.resul.todoapp.routine.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateRoutineYearlyRequest(
        @NotBlank(message = "Rutin adı boş olamaz.")
        String routineName,

        String routineDescription,

        @NotNull(message = "Lütfen önem derecesini 1'den 5'e kadar (1 ve 5 dahil) olacak şekilde belirtiniz.")
        Double importance
) {}