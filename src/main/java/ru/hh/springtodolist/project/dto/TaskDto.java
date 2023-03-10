package ru.hh.springtodolist.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.hh.springtodolist.project.model.Urgency;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

  private Long id;
  private String title;
  private Urgency urgency;

  public TaskDto(Long id, String title, Urgency urgency) {
    this.id = id;
    this.title = title;
    this.urgency = urgency;
  }
}
