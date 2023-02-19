package ru.hh.springtodolist.project.service;

import java.util.List;

public abstract class GenericService<T, N> {
    
    public abstract T update(T object);
    
    public abstract T updateFromDTO(N object, Long authorId);
    
    public abstract T createFromDTO(N newDtoObject);
    
    public abstract T createFromEntity(T newObject);
    
    public abstract void delete(final Long objectId);
    
    public abstract T getOne(final Long objectId);
    
    public abstract List<T> listAll();
}
