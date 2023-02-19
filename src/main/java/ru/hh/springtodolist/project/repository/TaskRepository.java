package ru.hh.springtodolist.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hh.springtodolist.project.model.Task;

@Repository
public interface TaskRepository
    extends JpaRepository<Task, Long> {
}