package com.resul.todoapp.sprint.repository;

import com.resul.todoapp.sprint.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> getTasksByIssueDateBetween(LocalDate p0, LocalDate p1);
}
