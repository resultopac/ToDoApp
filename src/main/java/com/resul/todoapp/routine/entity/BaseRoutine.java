package com.resul.todoapp.routine.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "routine_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BaseRoutine {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseRoutine(Long id) {
        this.id = id;
    }

    public BaseRoutine() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
