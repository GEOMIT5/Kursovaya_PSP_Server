package org.work.domen.service.factory;

import org.work.domen.service.SegmentService;
import org.work.domen.service.ProjectService;
import org.work.domen.service.UserService;
import org.work.domen.service.impl.SegmentServiceImpl;
import org.work.domen.service.impl.ProjectServiceImpl;
import org.work.domen.service.impl.UserServiceImpl;

public final class ServiceFactory {

    private static ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }


    private UserService userService = new UserServiceImpl();
    private SegmentService segmentService = new SegmentServiceImpl();
    private ProjectService projectService = new ProjectServiceImpl();

    public UserService getUserService() {
        return userService;
    }

    public SegmentService getSegmentService() {
        return segmentService;
    }

    public ProjectService getProjectService() {
        return projectService;
    }
}
