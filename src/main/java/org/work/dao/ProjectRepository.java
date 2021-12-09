package org.work.dao;

import org.work.dao.core.CrudRepository;
import org.work.dao.exception.DAOException;
import org.work.domen.entity.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project> {

    @Override
    Project getEntityById(String id) throws DAOException;

    @Override
    boolean removeById(String id) throws DAOException;

    @Override
    boolean add(Project project) throws DAOException;

    @Override
    boolean update(Project project) throws DAOException;

    @Override
    List<Project> getAll() throws DAOException;

    List<Project> getAllMarkedProducts() throws DAOException;

    List<Project> getAllNonMarkedProducts() throws DAOException;

}
