package ru.hh.springtodolist.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
@Setter
@ToString
@SequenceGenerator(name = "default_gen", sequenceName = "books_seq", allocationSize = 1)
public class Task
      extends GenericModel {

    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "urgency")
    @Enumerated
    private Urgency urgency;

}
