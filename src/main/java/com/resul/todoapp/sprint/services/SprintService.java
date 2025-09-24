package com.resul.todoapp.sprint.services;

import com.resul.todoapp.sprint.dto.mapper.SprintMapper;
import com.resul.todoapp.sprint.dto.request.CreateSprintRequest;
import com.resul.todoapp.sprint.dto.request.UpdateSprintRequest;
import com.resul.todoapp.sprint.dto.response.SprintResponse;
import com.resul.todoapp.sprint.entity.Sprint;
import com.resul.todoapp.sprint.entity.Task;
import com.resul.todoapp.sprint.repository.SprintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {

    private final SprintRepository sprintRepository;
    private final SprintMapper sprintMapper;

    public SprintService(SprintRepository sprintRepository, SprintMapper sprintMapper) {
        this.sprintRepository = sprintRepository;
        this.sprintMapper = sprintMapper;
    }

    public Sprint createSprint(CreateSprintRequest createSprintRequest) {
        Sprint sprint = sprintMapper.toSprintFromCreateRequest(createSprintRequest);
        return sprintRepository.save(sprint);
    }

    public Sprint updateSprint(long id, UpdateSprintRequest updateSprintRequest) {
        Sprint dbSprint = sprintRepository.getById(id);
        Sprint updated = sprintMapper.toSprintFromUpdateRequest(dbSprint, updateSprintRequest);
        return sprintRepository.save(updated);
    }

    public void deleteSprint(long id) {
        Sprint dbSprint = sprintRepository.getById(id);
        sprintRepository.delete(dbSprint);
    }

    public List<SprintResponse> getAllSprints() {
        return sprintMapper.toSprintResponseFromList(sprintRepository.findAll());
    }

    public SprintResponse getSprintById(long id) {
        Sprint dbSprint = sprintRepository.getById(id);
        SprintResponse response = sprintMapper.toSprintResponse(dbSprint);
        return response;
    }
}
