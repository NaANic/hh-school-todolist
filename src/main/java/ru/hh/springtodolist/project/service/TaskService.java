package ru.hh.springtodolist.project.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hh.springtodolist.project.dto.TaskDTO;
import ru.hh.springtodolist.project.model.Task;
import ru.hh.springtodolist.project.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public Task createFromDTO(TaskDTO taskDTO) {
    Task task = new Task();
    task.setTitle(taskDTO.getTitle());
    task.setUrgency(taskDTO.getUrgency());
    task.setCreatedBy("ADMIN");
    task.setCreatedWhen(LocalDateTime.now());
    return taskRepository.save(task);
  }

  public void delete(Long objectId) {
    Task task = taskRepository.findById(objectId).orElseThrow(
        () -> new NotFoundException("Such task with id=" + objectId + " now found"));
    taskRepository.delete(task);
  }

//  public List<Task> listAll() {
//    return taskRepository.findAll();
//  }

  public List<TaskDTO> getAllTasks() {
    List<Task> tasks = taskRepository.findAll();
    List<TaskDTO> taskDTOList = new ArrayList<>();
    for (Task task : tasks) {
      TaskDTO taskDTO = new TaskDTO(task);
      taskDTOList.add(taskDTO);
    }
    return taskDTOList;
  }
}