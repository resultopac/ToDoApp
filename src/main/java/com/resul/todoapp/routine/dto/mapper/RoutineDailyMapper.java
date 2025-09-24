package com.resul.todoapp.routine.dto.mapper;

import com.resul.todoapp.routine.dto.request.CreateRoutineDailyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineDailyRequest;
import com.resul.todoapp.routine.entity.RoutineDaily;
import org.springframework.stereotype.Component;

@Component
public class RoutineDailyMapper {

    public RoutineDaily toRoutineDailyFromCreateRequest(CreateRoutineDailyRequest createRoutineDailyRequest) {
        RoutineDaily routineDaily = new RoutineDaily();
        routineDaily.setRoutineName(createRoutineDailyRequest.routineName());
        routineDaily.setRoutineDescription(createRoutineDailyRequest.routineDescription());
        routineDaily.setDone(false);
        routineDaily.setImportance(createRoutineDailyRequest.importance());
        return routineDaily;
    }

    public RoutineDaily toRoutineDailyFromUpdateRequest(RoutineDaily routineDaily,
                                                        UpdateRoutineDailyRequest updateRoutineDailyRequest) {
        routineDaily.setRoutineName(updateRoutineDailyRequest.routineName());
        routineDaily.setRoutineDescription(updateRoutineDailyRequest.routineDescription());
        routineDaily.setImportance(updateRoutineDailyRequest.importance());
        routineDaily.setDone(updateRoutineDailyRequest.isDone());
        return routineDaily;
    }

    public RoutineDaily toDoRoutineDaily(RoutineDaily routineDaily) {
        routineDaily.setDone(true);
        return routineDaily;
    }
    public RoutineDaily toUndoRoutineDaily(RoutineDaily routineDaily) {
        routineDaily.setDone(false);
        return routineDaily;
    }

}
