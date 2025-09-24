package com.resul.todoapp.routine.dto.mapper;

import com.resul.todoapp.routine.dto.request.CreateRoutineWeeklyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineWeeklyRequest;
import com.resul.todoapp.routine.entity.RoutineWeekly;
import org.springframework.stereotype.Component;

@Component
public class RoutineWeeklyMapper {

    public RoutineWeekly toRoutineWeeklyFromCreateRequest(CreateRoutineWeeklyRequest createRoutineWeeklyRequest) {
        RoutineWeekly routineWeekly = new RoutineWeekly();
        routineWeekly.setRoutineName(createRoutineWeeklyRequest.routineName());
        routineWeekly.setRoutineDescription(createRoutineWeeklyRequest.routineDescription());
        routineWeekly.setDone(false);
        routineWeekly.setImportance(createRoutineWeeklyRequest.importance());
        return routineWeekly;
    }

    public RoutineWeekly toRoutineWeeklyFromUpdateRequest(RoutineWeekly routineWeekly,
                                                        UpdateRoutineWeeklyRequest updateRoutineWeeklyRequest) {
        routineWeekly.setRoutineName(updateRoutineWeeklyRequest.routineName());
        routineWeekly.setRoutineDescription(updateRoutineWeeklyRequest.routineDescription());
        routineWeekly.setImportance(updateRoutineWeeklyRequest.importance());
        routineWeekly.setDone(updateRoutineWeeklyRequest.isDone());
        return routineWeekly;
    }

    public RoutineWeekly toDoRoutineWeekly(RoutineWeekly routineWeekly) {
        routineWeekly.setDone(true);
        return routineWeekly;
    }
    public RoutineWeekly toUndoRoutineWeekly(RoutineWeekly routineWeekly) {
        routineWeekly.setDone(false);
        return routineWeekly;
    }

}
