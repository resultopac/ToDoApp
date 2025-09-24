package com.resul.todoapp.routine.dto.mapper;

import com.resul.todoapp.routine.dto.request.CreateRoutineYearlyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineYearlyRequest;
import com.resul.todoapp.routine.entity.RoutineYearly;
import org.springframework.stereotype.Component;

@Component
public class RoutineYearlyMapper {

    public RoutineYearly toRoutineYearlyFromCreateRequest(CreateRoutineYearlyRequest createRoutineYearlyRequest) {
        RoutineYearly routineYearly = new RoutineYearly();
        routineYearly.setRoutineName(createRoutineYearlyRequest.routineName());
        routineYearly.setRoutineDescription(createRoutineYearlyRequest.routineDescription());
        routineYearly.setDone(false);
        routineYearly.setImportance(createRoutineYearlyRequest.importance());
        return routineYearly;
    }

    public RoutineYearly toRoutineYearlyFromUpdateRequest(RoutineYearly routineYearly,
                                                        UpdateRoutineYearlyRequest updateRoutineYearlyRequest) {
        routineYearly.setRoutineName(updateRoutineYearlyRequest.routineName());
        routineYearly.setRoutineDescription(updateRoutineYearlyRequest.routineDescription());
        routineYearly.setImportance(updateRoutineYearlyRequest.importance());
        routineYearly.setDone(updateRoutineYearlyRequest.isDone());
        return routineYearly;
    }

    public RoutineYearly toDoRoutineYearly(RoutineYearly routineYearly) {
        routineYearly.setDone(true);
        return routineYearly;
    }
    public RoutineYearly toUndoRoutineYearly(RoutineYearly routineYearly) {
        routineYearly.setDone(false);
        return routineYearly;
    }

}
