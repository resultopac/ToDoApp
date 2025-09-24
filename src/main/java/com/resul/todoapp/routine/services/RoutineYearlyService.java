package com.resul.todoapp.routine.services;

import com.resul.todoapp.routine.dto.mapper.RoutineYearlyMapper;
import com.resul.todoapp.routine.dto.request.CreateRoutineYearlyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineYearlyRequest;
import com.resul.todoapp.routine.entity.RoutineYearly;
import com.resul.todoapp.routine.entity.RoutineYearly;
import com.resul.todoapp.routine.repository.RoutineYearlyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineYearlyService {

    private final RoutineYearlyRepository routineYearlyRepository;
    private final RoutineYearlyMapper routineYearlyMapper;

    public RoutineYearlyService(RoutineYearlyRepository routineYearlyRepository, RoutineYearlyMapper routineYearlyMapper) {
        this.routineYearlyRepository = routineYearlyRepository;
        this.routineYearlyMapper = routineYearlyMapper;
    }

    @Transactional
    public RoutineYearly createRoutineYearly(CreateRoutineYearlyRequest request) {
        RoutineYearly routineYearly = routineYearlyMapper.toRoutineYearlyFromCreateRequest(request);
        return routineYearlyRepository.save(routineYearly);
    }

    @Transactional
    public RoutineYearly updateRoutineYearly( long id,UpdateRoutineYearlyRequest request) {
        RoutineYearly dbRoutineYearly = routineYearlyRepository.getById(id);
        RoutineYearly updated = routineYearlyMapper.toRoutineYearlyFromUpdateRequest(dbRoutineYearly, request);
        return routineYearlyRepository.save(updated);
    }

    @Transactional
    public void deleteRoutineYearlyById(long id) {
        RoutineYearly dbRoutineYearly = routineYearlyRepository.getById(id);
        routineYearlyRepository.delete(dbRoutineYearly);
    }

    @Transactional
    public RoutineYearly doRoutineYearly(long id) {
        RoutineYearly dbRoutineYearly = routineYearlyRepository.getById(id);
        RoutineYearly doneRoutineYearly = routineYearlyMapper.toDoRoutineYearly(dbRoutineYearly);
        return doneRoutineYearly;
    }

    @Transactional
    public RoutineYearly undoRoutineYearly(long id) {
        RoutineYearly dbRoutineYearly = routineYearlyRepository.getById(id);
        RoutineYearly undoRoutineYearly = routineYearlyMapper.toUndoRoutineYearly(dbRoutineYearly);
        return undoRoutineYearly;
    }


    public List<RoutineYearly> getAllRoutineYearly() {
        return routineYearlyRepository.findAll();
    }

    public RoutineYearly getRoutineYearlyById(long id) {
        return routineYearlyRepository.getById(id);
    }
}
