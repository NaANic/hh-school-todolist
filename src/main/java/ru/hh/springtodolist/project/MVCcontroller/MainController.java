package ru.hh.springtodolist.project.MVCcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hh.springtodolist.project.service.TaskService;

@Controller
public class MainController {
    //localhost:9090/api/
    private final TaskService taskService;

    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks/viewAllTasks";
    }
}