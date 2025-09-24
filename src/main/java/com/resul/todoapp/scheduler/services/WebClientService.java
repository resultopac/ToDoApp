package com.resul.todoapp.scheduler.services;

import com.resul.todoapp.scheduler.request.CreateMultipleTaskForFirstTime;
import com.resul.todoapp.sprint.dto.request.CreateMultipleTaskRequest;
import org.springframework.stereotype.Service;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebClientService {

    WebClient CREATE_TASKS_CLIENT = WebClient.create("http://localhost:8000/api/create-sprint");

    public CreateMultipleTaskRequest createMultipleTask(String sprintInfo, String userContent,String taskInfos) throws Exception {

        CreateMultipleTaskForFirstTime request = new CreateMultipleTaskForFirstTime(sprintInfo, userContent, taskInfos);

        return CREATE_TASKS_CLIENT.post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreateMultipleTaskRequest.class)
                .block();
    }

}
