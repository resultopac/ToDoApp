package com.resul.todoapp.routine.services;

import com.resul.todoapp.routine.dto.mapper.RoutineDailyMapper;
import com.resul.todoapp.routine.dto.request.CreateRoutineDailyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineDailyRequest;
import com.resul.todoapp.routine.entity.RoutineDaily;
import com.resul.todoapp.routine.repository.RoutineDailyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineDailyService {

    private final RoutineDailyRepository routineDailyRepository;
    private final RoutineDailyMapper routineDailyMapper;

    public RoutineDailyService(RoutineDailyRepository routineDailyRepository, RoutineDailyMapper routineDailyMapper) {
        this.routineDailyRepository = routineDailyRepository;
        this.routineDailyMapper = routineDailyMapper;
    }

    @Transactional
    public RoutineDaily createRoutineDaily(CreateRoutineDailyRequest request) {
        RoutineDaily routineDaily = routineDailyMapper.toRoutineDailyFromCreateRequest(request);
        return routineDailyRepository.save(routineDaily);
    }

    @Transactional
    public RoutineDaily updateRoutineDaily(long id, UpdateRoutineDailyRequest request) {
        RoutineDaily dbRoutineDaily = routineDailyRepository.getById(id);
        RoutineDaily updated = routineDailyMapper.toRoutineDailyFromUpdateRequest(dbRoutineDaily, request);
        return routineDailyRepository.save(updated);
    }

    @Transactional
    public void deleteRoutineDailyById(long id) {
        RoutineDaily dbRoutineDaily = routineDailyRepository.getById(id);
        routineDailyRepository.delete(dbRoutineDaily);
    }

    @Transactional
    public RoutineDaily doRoutineDaily(long id) {
        RoutineDaily dbRoutineDaily = routineDailyRepository.getById(id);
        RoutineDaily doneRoutineDaily = routineDailyMapper.toDoRoutineDaily(dbRoutineDaily);
        return doneRoutineDaily;
    }

    @Transactional
    public RoutineDaily undoRoutineDaily(long id) {
        RoutineDaily dbRoutineDaily = routineDailyRepository.getById(id);
        RoutineDaily undoRoutineDaily = routineDailyMapper.toUndoRoutineDaily(dbRoutineDaily);
        return undoRoutineDaily;
    }

    public List<RoutineDaily> getAllRoutineDaily() {
        return routineDailyRepository.findAll();
    }

    public RoutineDaily getRoutineDailyById(long id) {
        return routineDailyRepository.getById(id);
    }
}
