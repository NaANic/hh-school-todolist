package ru.hh.springtodolist.project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericModel
      implements Serializable {
    //serialver - команда встроенная в JDK
    static final long SerialVersionUID = -4862926644813433707L;
    
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    private Long id;
    
    @Column(name = "created_when")
    private LocalDateTime createdWhen;
    
    @Column(name = "created_by")
    private String createdBy;

}
