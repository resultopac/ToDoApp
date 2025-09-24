package com.resul.todoapp.routine.repository;

import com.resul.todoapp.routine.entity.RoutineWeekly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineWeeklyRepository extends JpaRepository<RoutineWeekly,Long> {
}
