package com.resul.todoapp.sprint.services;

import com.resul.todoapp.routine.entity.RoutineDaily;
import com.resul.todoapp.scheduler.request.CreateMultipleTaskForFirstTime;
import com.resul.todoapp.scheduler.services.WebClientService;
import com.resul.todoapp.sprint.dto.mapper.TaskMapper;
import com.resul.todoapp.sprint.dto.request.CreateMultipleTaskRequest;
import com.resul.todoapp.sprint.dto.request.CreateTaskRequest;
import com.resul.todoapp.sprint.dto.request.UpdateTaskRequest;
import com.resul.todoapp.sprint.dto.response.SprintResponse;
import com.resul.todoapp.sprint.dto.response.TaskResponse;
import com.resul.todoapp.sprint.entity.Sprint;
import com.resul.todoapp.sprint.entity.Task;
import com.resul.todoapp.sprint.repository.SprintRepository;
import com.resul.todoapp.sprint.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final SprintRepository sprintRepository;
    private final TaskMapper taskMapper;
    private final WebClientService  webClientService;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, SprintRepository sprintRepository, WebClientService webClientService) {
        this.taskRepository = taskRepository;
        this.sprintRepository = sprintRepository;
        this.taskMapper = taskMapper;
        this.webClientService = webClientService;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public TaskResponse getTaskById(long id) {
        Task dbTask = taskRepository.getById(id);
        TaskResponse response = taskMapper.toTaskResponse(dbTask);
        return response;
    }

    @Transactional
    public Task updateTaskById(long id, UpdateTaskRequest request) {
        Task dbTask = taskRepository.getById(id);
        Task updated = taskMapper.toTaskFromUpdateRequest(dbTask,request);
        return taskRepository.save(updated);
    }

    public List<Task> createMultipleTasksBySprintId(String userContent,long id) throws Exception {
        Sprint sprint = sprintRepository.getById(id);
        List<Task> existedTasks = taskRepository.getTasksByIssueDateBetween(sprint.getStartDate(),sprint.getEndDate());
        String taskInfos = "";
        for (Task task : existedTasks){
            taskInfos += task.getTaskInfo();
        }
        CreateMultipleTaskRequest request = webClientService.createMultipleTask(sprint.getSprintInfo(),userContent,taskInfos);
        List<Task> tasks = taskMapper.toTasksFromCreateMultipleTaskRequest(request,sprint);
        return taskRepository.saveAll(tasks);
    }

    public TaskResponse createTaskBySprintId(CreateTaskRequest request,long id) {
        Sprint sprint = sprintRepository.getById(id);
        Task task = taskMapper.toTaskFromCreateRequest(request,sprint);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

    @Transactional
    public void deleteTaskById(long id) {
        Task dbTask = taskRepository.getById(id);
        taskRepository.delete(dbTask);
    }

    @Transactional
    public TaskResponse doTask(long id) {
        Task dbTask = taskRepository.getById(id);
        Task doneTask = taskMapper.toDoTask(dbTask);
        return taskMapper.toTaskResponse(doneTask);
    }

    @Transactional
    public TaskResponse undoTask(long id) {
        Task dbTask = taskRepository.getById(id);
        Task undoTask = taskMapper.toUndoTask(dbTask);
        return taskMapper.toTaskResponse(undoTask);
    }

}
