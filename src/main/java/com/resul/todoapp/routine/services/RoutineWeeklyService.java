package com.resul.todoapp.routine.services;

import com.resul.todoapp.routine.dto.mapper.RoutineWeeklyMapper;
import com.resul.todoapp.routine.dto.request.CreateRoutineWeeklyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineWeeklyRequest;
import com.resul.todoapp.routine.entity.RoutineWeekly;
import com.resul.todoapp.routine.entity.RoutineWeekly;
import com.resul.todoapp.routine.repository.RoutineWeeklyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineWeeklyService {

    private final RoutineWeeklyRepository routineWeeklyRepository;
    private final RoutineWeeklyMapper routineWeeklyMapper;

    public RoutineWeeklyService(RoutineWeeklyRepository routineWeeklyRepository, RoutineWeeklyMapper routineWeeklyMapper) {
        this.routineWeeklyRepository = routineWeeklyRepository;
        this.routineWeeklyMapper = routineWeeklyMapper;
    }

    @Transactional
    public RoutineWeekly createRoutineWeekly(CreateRoutineWeeklyRequest request) {
        RoutineWeekly routineWeekly = routineWeeklyMapper.toRoutineWeeklyFromCreateRequest(request);
        return routineWeeklyRepository.save(routineWeekly);
    }

    @Transactional
    public RoutineWeekly updateRoutineWeekly( long id,UpdateRoutineWeeklyRequest request) {
        RoutineWeekly dbRoutineWeekly = routineWeeklyRepository.getById(id);
        RoutineWeekly updated = routineWeeklyMapper.toRoutineWeeklyFromUpdateRequest(dbRoutineWeekly, request);
        return routineWeeklyRepository.save(updated);
    }

    @Transactional
    public void deleteRoutineWeeklyById(long id) {
        RoutineWeekly dbRoutineWeekly = routineWeeklyRepository.getById(id);
        routineWeeklyRepository.delete(dbRoutineWeekly);
    }

    @Transactional
    public RoutineWeekly doRoutineWeekly(long id) {
        RoutineWeekly dbRoutineWeekly = routineWeeklyRepository.getById(id);
        RoutineWeekly doneRoutineWeekly = routineWeeklyMapper.toDoRoutineWeekly(dbRoutineWeekly);
        return doneRoutineWeekly;
    }

    @Transactional
    public RoutineWeekly undoRoutineWeekly(long id) {
        RoutineWeekly dbRoutineWeekly = routineWeeklyRepository.getById(id);
        RoutineWeekly undoRoutineWeekly = routineWeeklyMapper.toUndoRoutineWeekly(dbRoutineWeekly);
        return undoRoutineWeekly;
    }

    public List<RoutineWeekly> getAllRoutineWeekly() {
        return routineWeeklyRepository.findAll();
    }

    public RoutineWeekly getRoutineWeeklyById(long id) {
        return routineWeeklyRepository.getById(id);
    }
}
