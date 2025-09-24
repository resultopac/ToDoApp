package com.resul.todoapp.routine.repository;

import com.resul.todoapp.routine.entity.RoutineDaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineDailyRepository extends JpaRepository<RoutineDaily,Long> {
}
