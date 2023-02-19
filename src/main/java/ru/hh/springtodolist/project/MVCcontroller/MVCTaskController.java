package ru.hh.springtodolist.project.MVCcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.hh.springtodolist.project.dto.TaskDTO;
import ru.hh.springtodolist.project.service.TaskService;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class MVCTaskController {
  private final TaskService taskService;

  public MVCTaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("tasks", taskService.getAllTasks());
    return "tasks/viewAllTasks";
  }

  @GetMapping("/add")
  public String create() {
    return "tasks/addTask";
  }

  @PostMapping("/add")
  public String create(@ModelAttribute("taskForm") @Valid TaskDTO taskDTO) {
    taskService.createFromDTO(taskDTO);
    return "redirect:/tasks";
  }

  @GetMapping("delete/{id}")
  public String delete(@PathVariable Long id) {
    taskService.delete(id);
    return "redirect:/tasks";
  }
}