package com.resul.todoapp.sprint.dto.mapper;

import com.resul.todoapp.sprint.dto.request.CreateMultipleTaskRequest;
import com.resul.todoapp.sprint.dto.request.CreateTaskRequest;
import com.resul.todoapp.sprint.dto.request.UpdateTaskRequest;
import com.resul.todoapp.sprint.dto.response.TaskResponse;
import com.resul.todoapp.sprint.entity.Sprint;
import com.resul.todoapp.sprint.entity.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {

    public Task toTaskFromCreateRequest(CreateTaskRequest createTaskRequest, Sprint sprint) {
        Task task = new Task();
        task.setTaskName(createTaskRequest.taskName());
        task.setTaskDescription(createTaskRequest.taskDescription());
        task.setIssueDate(createTaskRequest.issueDate());
        task.setImportance(createTaskRequest.importance());
        task.setDifficulty(createTaskRequest.difficulty());
        task.setDone(createTaskRequest.isDone());
        task.setSprint(sprint);
        return task;
    }

    public List<Task> toTasksFromCreateMultipleTaskRequest(CreateMultipleTaskRequest createMultipleTaskRequest, Sprint sprint) {
        List<Task> tasks = new ArrayList<>();
        for(CreateTaskRequest createTaskRequest : createMultipleTaskRequest.tasks()) {
            Task task = toTaskFromCreateRequest(createTaskRequest, sprint);
            tasks.add(task);
        }
        return tasks;
    }

    public Task toTaskFromUpdateRequest(Task task,UpdateTaskRequest updateTaskRequest) {
        task.setTaskName(updateTaskRequest.taskName());
        task.setTaskDescription(updateTaskRequest.taskDescription());
        task.setIssueDate(updateTaskRequest.issueDate());
        task.setImportance(updateTaskRequest.importance());
        task.setDone(updateTaskRequest.isDone());
        task.setDifficulty(updateTaskRequest.difficulty());
        return task;
    }

    public TaskResponse toTaskResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTaskName(task.getTaskName());
        taskResponse.setTaskDescription(task.getTaskDescription());
        taskResponse.setIssueDate(task.getIssueDate());
        taskResponse.setImportance(task.getImportance());
        taskResponse.setDone(task.isDone());
        taskResponse.setDifficulty(task.getDifficulty());
        return taskResponse;
    }

    public Task toDoTask(Task task) {
        task.setDone(true);
        return task;
    }
    public Task toUndoTask(Task task) {
        task.setDone(false);
        return task;
    }
}
