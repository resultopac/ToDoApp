package com.resul.todoapp.sprint.controller;

import com.resul.todoapp.sprint.dto.request.*;
import com.resul.todoapp.sprint.dto.response.TaskResponse;
import com.resul.todoapp.sprint.entity.Task;
import com.resul.todoapp.sprint.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll( ) {
        List<Task> tasks = taskService.getAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable Long id){
        TaskResponse task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/{id}")
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody CreateTaskRequest request, @PathVariable Long id) {
        TaskResponse created = taskService.createTaskBySprintId(request,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/multiple-task/{id}")
    public ResponseEntity<List<Task>> create(@Valid @RequestBody String userContent, @PathVariable Long id) throws Exception {
        List<Task> created = taskService.createMultipleTasksBySprintId(userContent,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping("/do/{id}")
    public ResponseEntity<TaskResponse> doTaskById(@PathVariable long id){
        return ResponseEntity.ok(taskService.doTask(id));
    }

    @PutMapping("/undo/{id}")
    public ResponseEntity<TaskResponse> undoTaskById(@PathVariable long id){
        return ResponseEntity.ok(taskService.undoTask(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateById(@Valid @RequestBody UpdateTaskRequest request,
                                             @PathVariable long id){
        return ResponseEntity.ok(taskService.updateTaskById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Task deleted successfully with id: " + id);
    }
}
