package com.resul.todoapp.routine.services;

import com.resul.todoapp.routine.dto.mapper.RoutineMonthlyMapper;
import com.resul.todoapp.routine.dto.request.CreateRoutineMonthlyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineMonthlyRequest;
import com.resul.todoapp.routine.entity.RoutineMonthly;
import com.resul.todoapp.routine.entity.RoutineMonthly;
import com.resul.todoapp.routine.repository.RoutineMonthlyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineMonthlyService {

    private final RoutineMonthlyRepository routineMonthlyRepository;
    private final RoutineMonthlyMapper routineMonthlyMapper;

    public RoutineMonthlyService(RoutineMonthlyRepository routineMonthlyRepository, RoutineMonthlyMapper routineMonthlyMapper) {
        this.routineMonthlyRepository = routineMonthlyRepository;
        this.routineMonthlyMapper = routineMonthlyMapper;
    }

    @Transactional
    public RoutineMonthly createRoutineMonthly(CreateRoutineMonthlyRequest request) {
        RoutineMonthly routineMonthly = routineMonthlyMapper.toRoutineMonthlyFromCreateRequest(request);
        return routineMonthlyRepository.save(routineMonthly);
    }

    @Transactional
    public RoutineMonthly updateRoutineMonthly( long id, UpdateRoutineMonthlyRequest request) {
        RoutineMonthly dbRoutineMonthly = routineMonthlyRepository.getById(id);
        RoutineMonthly updated = routineMonthlyMapper.toRoutineMonthlyFromUpdateRequest(dbRoutineMonthly, request);
        return routineMonthlyRepository.save(updated);
    }

    @Transactional
    public void deleteRoutineMonthlyById(long id) {
        RoutineMonthly dbRoutineMonthly = routineMonthlyRepository.getById(id);
        routineMonthlyRepository.delete(dbRoutineMonthly);
    }

    @Transactional
    public RoutineMonthly doRoutineMonthly(long id) {
        RoutineMonthly dbRoutineMonthly = routineMonthlyRepository.getById(id);
        RoutineMonthly doneRoutineMonthly = routineMonthlyMapper.toDoRoutineMonthly(dbRoutineMonthly);
        return doneRoutineMonthly;
    }

    @Transactional
    public RoutineMonthly undoRoutineMonthly(long id) {
        RoutineMonthly dbRoutineMonthly = routineMonthlyRepository.getById(id);
        RoutineMonthly undoRoutineMonthly = routineMonthlyMapper.toUndoRoutineMonthly(dbRoutineMonthly);
        return undoRoutineMonthly;
    }

    public List<RoutineMonthly> getAllRoutineMonthly() {
        return routineMonthlyRepository.findAll();
    }

    public RoutineMonthly getRoutineMonthlyById(long id) {
        return routineMonthlyRepository.getById(id);
    }
}
