package com.enigmacamp.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<PK, E> {
    public abstract boolean add(E entity) throws SQLException;
    public abstract boolean edit(E entity) throws SQLException;
    public abstract boolean removeById(E entity) throws SQLException;
    public abstract boolean remove(E entity) throws SQLException;
    public abstract E findById(PK entity) throws SQLException;
    public abstract  List<E> findAll () throws SQLException;

    
} 