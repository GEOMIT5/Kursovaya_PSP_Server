package org.work.domen.service.impl;

import org.work.dao.ProjectRepository;
import org.work.dao.exception.DAOException;
import org.work.dao.factory.RepositoryFactory;
import org.work.domen.entity.Project;
import org.work.domen.service.ProjectService;
import org.work.domen.service.exception.ServiceException;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository = RepositoryFactory.getInstance().getProjectRepository();

    @Override
    public void addNewProject(Project project) throws ServiceException {
        try {
            projectRepository.add(project);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateProject(Project project) throws ServiceException {
        try {
            projectRepository.update(project);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteProject(String companyId) throws ServiceException {
        try {
            projectRepository.removeById(companyId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Project> getProject() throws ServiceException {
        try {
            return projectRepository.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public List<Project> getMarkedProject() throws ServiceException {
        try {
            return projectRepository.getAllMarkedProducts();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Project> getNotMarkedProject() throws ServiceException {
        try {
            return projectRepository.getAllNonMarkedProducts();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
