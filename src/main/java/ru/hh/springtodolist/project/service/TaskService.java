package ru.hh.springtodolist.project.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hh.springtodolist.project.dto.TaskDto;
import ru.hh.springtodolist.project.model.Task;
import ru.hh.springtodolist.project.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public void createFromDTO(TaskDto taskDTO) {
    Task task = new Task();
    task.setTitle(taskDTO.getTitle());
    task.setUrgency(taskDTO.getUrgency());
    task.setCreatedBy("ADMIN");
    task.setCreatedWhen(LocalDateTime.now());
    taskRepository.save(task);
  }

  public void delete(Long objectId) {
    Task task = taskRepository.findById(objectId).orElseThrow(
        () -> new NotFoundException("Such task with id=" + objectId + " now found"));
    taskRepository.delete(task);
  }

  public List<TaskDto> getAllTasks() {
    return taskRepository
        .findAll()
        .stream()
        .map(this::taskDtoConverter)
        .toList();
  }

  public TaskDto taskDtoConverter(Task task) {
    return new TaskDto(task.getId(), task.getTitle(), task.getUrgency());
  }
}
