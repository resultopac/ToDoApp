package com.resul.todoapp.routine.controller;

import com.resul.todoapp.routine.dto.request.CreateRoutineDailyRequest;
import com.resul.todoapp.routine.dto.request.UpdateRoutineDailyRequest;
import com.resul.todoapp.routine.entity.RoutineDaily;
import com.resul.todoapp.routine.services.RoutineDailyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine-daily")
public class RoutineDailyController {

    private final RoutineDailyService routineDailyService;

    public RoutineDailyController(RoutineDailyService routineDailyService) {
        this.routineDailyService = routineDailyService;
    }

    @GetMapping
    public ResponseEntity<List<RoutineDaily>> getAll( ) {
        List<RoutineDaily> routines = routineDailyService.getAllRoutineDaily();
        return ResponseEntity.ok(routines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineDaily> findById(@PathVariable Long id){
        RoutineDaily routine = routineDailyService.getRoutineDailyById(id);
        return ResponseEntity.ok(routine);
    }

    @PostMapping
    public ResponseEntity<RoutineDaily> create(@Valid @RequestBody CreateRoutineDailyRequest request) {
        RoutineDaily created = routineDailyService.createRoutineDaily(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoutineDaily> updateById(@Valid @RequestBody UpdateRoutineDailyRequest request,
                                                              @PathVariable long id){
        return ResponseEntity.ok(routineDailyService.updateRoutineDaily(id, request));
    }

    @PutMapping("/do/{id}")
    public ResponseEntity<RoutineDaily> doRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineDailyService.doRoutineDaily(id));
    }

    @PutMapping("/undo/{id}")
    public ResponseEntity<RoutineDaily> undoRoutineById(@PathVariable long id){
        return ResponseEntity.ok(routineDailyService.undoRoutineDaily(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        routineDailyService.deleteRoutineDailyById(id);
        return ResponseEntity.ok("Routine deleted successfully with id: " + id);
    }

}