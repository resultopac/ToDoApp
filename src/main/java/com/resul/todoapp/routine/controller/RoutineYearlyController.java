package com.resul.todoapp.routine.controller;

import com.resul.todoapp.routine.dto.request.CreateRoutineYearlyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineYearlyRequest;
import com.resul.todoapp.routine.entity.RoutineYearly;
import com.resul.todoapp.routine.entity.RoutineYearly;
import com.resul.todoapp.routine.services.RoutineYearlyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine-yearly")
public class RoutineYearlyController {

    private final RoutineYearlyService routineYearlyService;

    public RoutineYearlyController(RoutineYearlyService routineYearlyService) {
        this.routineYearlyService = routineYearlyService;
    }

    @GetMapping
    public ResponseEntity<List<RoutineYearly>> getAll( ) {
        List<RoutineYearly> routines = routineYearlyService.getAllRoutineYearly();
        return ResponseEntity.ok(routines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineYearly> findById(@PathVariable Long id){
        RoutineYearly routine = routineYearlyService.getRoutineYearlyById(id);
        return ResponseEntity.ok(routine);
    }

    @PostMapping
    public ResponseEntity<RoutineYearly> create(@Valid @RequestBody CreateRoutineYearlyRequest request) {
        RoutineYearly created = routineYearlyService.createRoutineYearly(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoutineYearly> updateById(@Valid @RequestBody UpdateRoutineYearlyRequest request,
                                                   @PathVariable long id){
        return ResponseEntity.ok(routineYearlyService.updateRoutineYearly(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        routineYearlyService.deleteRoutineYearlyById(id);
        return ResponseEntity.ok("Routine deleted successfully with id: " + id);
    }

    @PutMapping("/do/{id}")
    public ResponseEntity<RoutineYearly> doRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineYearlyService.doRoutineYearly(id));
    }

    @PutMapping("/undo/{id}")
    public ResponseEntity<RoutineYearly> undoRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineYearlyService.undoRoutineYearly(id));
    }

}