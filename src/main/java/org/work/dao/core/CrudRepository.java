package org.work.dao.core;

import org.work.dao.exception.DAOException;


import java.util.List;

public interface CrudRepository<T> {

    T getEntityById(String id) throws DAOException;

    boolean removeById(String id) throws DAOException;

    boolean add(T t) throws DAOException;

    boolean update(T t) throws DAOException;

    List<T> getAll() throws DAOException;

}
