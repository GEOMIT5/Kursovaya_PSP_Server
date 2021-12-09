package org.work.domen.service;

import org.work.domen.entity.Project;
import org.work.domen.service.exception.ServiceException;

import java.util.List;

public interface ProjectService {

    void addNewProject(Project project) throws ServiceException;

    void updateProject(Project project) throws ServiceException;

    void deleteProject(String companyId) throws ServiceException;

    List<Project> getProject() throws ServiceException;


    List<Project> getMarkedProject() throws ServiceException;

    List<Project> getNotMarkedProject() throws ServiceException;
}
