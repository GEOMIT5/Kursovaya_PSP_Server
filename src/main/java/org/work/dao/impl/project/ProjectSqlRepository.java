package org.work.dao.impl.project;

import org.work.dao.ProjectRepository;
import org.work.dao.core.InitializerRepository;
import org.work.dao.core.exception.JdbcTemplateException;
import org.work.dao.exception.DAOException;
import org.work.dao.mapper.ProjectRowMapper;
import org.work.domen.entity.Project;

import java.util.List;

import static org.work.dao.impl.project.ProjectSqlUtil.*;

public class ProjectSqlRepository extends InitializerRepository implements ProjectRepository {


    @Override
    public Project getEntityById(String id) throws DAOException {
        try {
            return jdbcTemplate.queryForObject(GET_PROJECT_BY_ID, new ProjectRowMapper(), id);
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws DAOException {
        try {
            jdbcTemplate.update(REMOVE_PROJECT_BY_ID, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean add(Project project) throws DAOException {
        try {
            jdbcTemplate.update(ADD_NEW_PROJECT,
                    project.getSegment().getId(),
                    project.getStatus().getId(),
                    project.getName(),
                    project.getHead(),
                    project.getHumanAmount(),
                    project.getAverageSalary(),
                    project.getProfit(),
                    project.getTerm(),
                    project.getProfitability());
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean update(Project project) throws DAOException {
        try {
            jdbcTemplate.update(UPDATE_PROJECT,
                    project.getSegment().getId(),
                    project.getStatus().getId(),
                    project.getName(),
                    project.getHead(),
                    project.getHumanAmount(),
                    project.getAverageSalary(),
                    project.getProfit(),
                    project.getTerm(),
                    project.getProfitability(),
                    project.getId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Project> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(GET_ALL_PROJECT, new ProjectRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Project> getAllMarkedProducts() throws DAOException {
        try {
            return jdbcTemplate.query(GET_ALL_MARKED_PROJECT, new ProjectRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Project> getAllNonMarkedProducts() throws DAOException {
        try {
            return jdbcTemplate.query(GET_ALL_NOT_MARKED_PROJECT, new ProjectRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }
}
