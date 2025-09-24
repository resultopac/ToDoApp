package com.resul.todoapp.sprint.dto.mapper;

import com.resul.todoapp.sprint.dto.request.CreateSprintRequest;
import com.resul.todoapp.sprint.dto.request.UpdateSprintRequest;
import com.resul.todoapp.sprint.dto.response.SprintResponse;
import com.resul.todoapp.sprint.entity.Sprint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SprintMapper {

    public Sprint toSprintFromCreateRequest(CreateSprintRequest createSprintRequest) {
        Sprint sprint = new Sprint();
        sprint.setSprintName(createSprintRequest.sprintName());
        sprint.setStartDate(createSprintRequest.startDate());
        sprint.setEndDate(createSprintRequest.endDate());
        return sprint;
    }

    public Sprint toSprintFromUpdateRequest(Sprint sprint, UpdateSprintRequest updateSprintRequest) {
        sprint.setSprintName(updateSprintRequest.sprintName());
        sprint.setStartDate(updateSprintRequest.startDate());
        sprint.setEndDate(updateSprintRequest.endDate());
        return sprint;
    }

    public SprintResponse toSprintResponse(Sprint sprint) {
        SprintResponse sprintResponse = new SprintResponse();
        sprintResponse.setSprintName(sprint.getSprintName());
        sprintResponse.setStartDate(sprint.getStartDate());
        sprintResponse.setEndDate(sprint.getEndDate());
        sprintResponse.setTasks(sprint.getTasks());
        return sprintResponse;
    }

    public List<SprintResponse> toSprintResponseFromList(List<Sprint> sprints) {
        List<SprintResponse> sprintResponseList = new ArrayList<>();
        for (Sprint sprint : sprints) {
            sprintResponseList.add(toSprintResponse(sprint));
        }
        return sprintResponseList;
    }
}
