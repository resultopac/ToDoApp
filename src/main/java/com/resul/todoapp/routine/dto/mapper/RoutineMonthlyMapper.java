package com.resul.todoapp.routine.dto.mapper;

import com.resul.todoapp.routine.dto.request.CreateRoutineMonthlyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineMonthlyRequest;
import com.resul.todoapp.routine.entity.RoutineMonthly;
import org.springframework.stereotype.Component;

@Component
public class RoutineMonthlyMapper {

    public RoutineMonthly toRoutineMonthlyFromCreateRequest(CreateRoutineMonthlyRequest createRoutineMonthlyRequest) {
        RoutineMonthly routineMonthly = new RoutineMonthly();
        routineMonthly.setRoutineName(createRoutineMonthlyRequest.routineName());
        routineMonthly.setRoutineDescription(createRoutineMonthlyRequest.routineDescription());
        routineMonthly.setDone(false);
        routineMonthly.setImportance(createRoutineMonthlyRequest.importance());
        return routineMonthly;
    }

    public RoutineMonthly toRoutineMonthlyFromUpdateRequest(RoutineMonthly routineMonthly,
                                                            UpdateRoutineMonthlyRequest updateRoutineMonthlyRequest) {
        routineMonthly.setRoutineName(updateRoutineMonthlyRequest.routineName());
        routineMonthly.setRoutineDescription(updateRoutineMonthlyRequest.routineDescription());
        routineMonthly.setImportance(updateRoutineMonthlyRequest.importance());
        routineMonthly.setDone(updateRoutineMonthlyRequest.isDone());
        return routineMonthly;
    }

    public RoutineMonthly toDoRoutineMonthly(RoutineMonthly routineMonthly) {
        routineMonthly.setDone(true);
        return routineMonthly;
    }
    public RoutineMonthly toUndoRoutineMonthly(RoutineMonthly routineMonthly) {
        routineMonthly.setDone(false);
        return routineMonthly;
    }
}
