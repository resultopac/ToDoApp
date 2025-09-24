package com.resul.todoapp.routine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("YEARLY")
public class RoutineYearly extends BaseRoutine {

    @Column(name = "routine_name", unique = true)
    private String routineName;
    @Column(name = "routine_description")
    private String routineDescription;
    @Column(name = "importance")
    private Double importance;
    @Column(name = "is_done")
    private boolean isDone;

    public RoutineYearly(Long id, String routineName, String routineDescription, Double importance, boolean isDone) {
        super(id);
        this.routineName = routineName;
        this.routineDescription = routineDescription;
        this.importance = importance;
        this.isDone = isDone;
    }

    public RoutineYearly(String routineName, String routineDescription, Double importance, boolean isDone) {
        this.routineName = routineName;
        this.routineDescription = routineDescription;
        this.importance = importance;
        this.isDone = isDone;
    }

    public RoutineYearly() {}

    public String getRoutineName() {
        return routineName;
    }

    public void setRoutineName(String routineName) {
        this.routineName = routineName;
    }

    public String getRoutineDescription() {
        return routineDescription;
    }

    public void setRoutineDescription(String routineDescription) {
        this.routineDescription = routineDescription;
    }

    public Double getImportance() {
        return importance;
    }

    public void setImportance(Double importance) {
        this.importance = importance;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
