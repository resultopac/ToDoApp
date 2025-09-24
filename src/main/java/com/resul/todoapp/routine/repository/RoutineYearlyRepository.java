package com.resul.todoapp.routine.repository;

import com.resul.todoapp.routine.entity.RoutineYearly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineYearlyRepository extends JpaRepository<RoutineYearly,Long> {
}
