package com.resul.todoapp.sprint.controller;

import com.resul.todoapp.sprint.dto.request.CreateSprintRequest;
import com.resul.todoapp.sprint.dto.request.UpdateSprintRequest;
import com.resul.todoapp.sprint.dto.response.SprintResponse;
import com.resul.todoapp.sprint.entity.Sprint;
import com.resul.todoapp.sprint.services.SprintService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprint")
public class SprintController {

    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping
    public ResponseEntity<List<SprintResponse>> getAll( ) {
        List<SprintResponse> sprints = sprintService.getAllSprints();
        return ResponseEntity.ok(sprints);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SprintResponse> findById(@PathVariable Long id){
        SprintResponse sprint = sprintService.getSprintById(id);
        return ResponseEntity.ok(sprint);
    }

    @PostMapping
    public ResponseEntity<Sprint> create(@Valid @RequestBody CreateSprintRequest request) {
        Sprint created = sprintService.createSprint(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sprint> updateById(@Valid @RequestBody UpdateSprintRequest request,
                                                   @PathVariable long id){
        return ResponseEntity.ok(sprintService.updateSprint(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        sprintService.deleteSprint(id);
        return ResponseEntity.ok("Sprint deleted successfully with id: " + id);
    }
}
