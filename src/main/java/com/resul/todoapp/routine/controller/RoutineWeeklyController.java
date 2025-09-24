package com.resul.todoapp.routine.controller;

import com.resul.todoapp.routine.dto.request.CreateRoutineWeeklyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineWeeklyRequest;
import com.resul.todoapp.routine.entity.RoutineWeekly;
import com.resul.todoapp.routine.entity.RoutineWeekly;
import com.resul.todoapp.routine.services.RoutineWeeklyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine-weekly")
public class RoutineWeeklyController {

    private final RoutineWeeklyService routineWeeklyService;

    public RoutineWeeklyController(RoutineWeeklyService routineWeeklyService) {
        this.routineWeeklyService = routineWeeklyService;
    }

    @GetMapping
    public ResponseEntity<List<RoutineWeekly>> getAll( ) {
        List<RoutineWeekly> routines = routineWeeklyService.getAllRoutineWeekly();
        return ResponseEntity.ok(routines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineWeekly> findById(@PathVariable Long id){
        RoutineWeekly routine = routineWeeklyService.getRoutineWeeklyById(id);
        return ResponseEntity.ok(routine);
    }

    @PostMapping
    public ResponseEntity<RoutineWeekly> create(@Valid @RequestBody CreateRoutineWeeklyRequest request) {
        RoutineWeekly created = routineWeeklyService.createRoutineWeekly(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoutineWeekly> updateById(@Valid @RequestBody UpdateRoutineWeeklyRequest request,
                                                   @PathVariable long id){
        return ResponseEntity.ok(routineWeeklyService.updateRoutineWeekly(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        routineWeeklyService.deleteRoutineWeeklyById(id);
        return ResponseEntity.ok("Routine deleted successfully with id: " + id);
    }

    @PutMapping("/do/{id}")
    public ResponseEntity<RoutineWeekly> doRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineWeeklyService.doRoutineWeekly(id));
    }

    @PutMapping("/undo/{id}")
    public ResponseEntity<RoutineWeekly> undoRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineWeeklyService.undoRoutineWeekly(id));
    }

}