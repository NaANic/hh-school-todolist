package ru.hh.springtodolist.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hh.springtodolist.project.model.Task;
import ru.hh.springtodolist.project.model.Urgency;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO
      extends CommonDTO
{
    
    private Long id;
    private String title;
    private Urgency urgency;
    
    public TaskDTO(final Task task) {
        this.id = task.getId();
        this.urgency = task.getUrgency();
        this.title = task.getTitle();
    }
}