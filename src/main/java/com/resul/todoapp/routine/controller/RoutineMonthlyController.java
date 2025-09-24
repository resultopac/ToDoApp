package com.resul.todoapp.routine.controller;

import com.resul.todoapp.routine.dto.request.CreateRoutineMonthlyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineMonthlyRequest;
import com.resul.todoapp.routine.entity.RoutineMonthly;
import com.resul.todoapp.routine.entity.RoutineMonthly;
import com.resul.todoapp.routine.services.RoutineMonthlyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine-monthly")
public class RoutineMonthlyController {

    private final RoutineMonthlyService routineMonthlyService;

    public RoutineMonthlyController(RoutineMonthlyService routineMonthlyService) {
        this.routineMonthlyService = routineMonthlyService;
    }

    @GetMapping
    public ResponseEntity<List<RoutineMonthly>> getAll( ) {
        List<RoutineMonthly> routines = routineMonthlyService.getAllRoutineMonthly();
        return ResponseEntity.ok(routines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineMonthly> findById(@PathVariable Long id){
        RoutineMonthly routine = routineMonthlyService.getRoutineMonthlyById(id);
        return ResponseEntity.ok(routine);
    }

    @PostMapping
    public ResponseEntity<RoutineMonthly> create(@Valid @RequestBody CreateRoutineMonthlyRequest request) {
        RoutineMonthly created = routineMonthlyService.createRoutineMonthly(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoutineMonthly> updateById(@Valid @RequestBody UpdateRoutineMonthlyRequest request,
                                                   @PathVariable long id){
        return ResponseEntity.ok(routineMonthlyService.updateRoutineMonthly(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        routineMonthlyService.deleteRoutineMonthlyById(id);
        return ResponseEntity.ok("Routine deleted successfully with id: " + id);
    }

    @PutMapping("/do/{id}")
    public ResponseEntity<RoutineMonthly> doRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineMonthlyService.doRoutineMonthly(id));
    }

    @PutMapping("/undo/{id}")
    public ResponseEntity<RoutineMonthly> undoRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineMonthlyService.undoRoutineMonthly(id));
    }

}