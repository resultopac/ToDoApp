package com.resul.todoapp.routine.repository;

import com.resul.todoapp.routine.entity.RoutineMonthly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineMonthlyRepository extends JpaRepository<RoutineMonthly,Long> {
}
