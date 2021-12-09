package org.work.dao.factory;

import org.work.dao.SegmentRepository;
import org.work.dao.ProjectRepository;
import org.work.dao.UserRepository;
import org.work.dao.impl.segment.SegmentSqlRepository;
import org.work.dao.impl.project.ProjectSqlRepository;
import org.work.dao.impl.user.UserSqlRepository;

public final class RepositoryFactory {
    private static final RepositoryFactory instance = new RepositoryFactory();

    public static RepositoryFactory getInstance() {
        return instance;
    }

    private RepositoryFactory() {

    }


    private UserRepository userRepository = new UserSqlRepository();
    private SegmentRepository segmentRepository = new SegmentSqlRepository();

    private ProjectRepository projectRepository = new ProjectSqlRepository();

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SegmentRepository getSegmentRepository() {
        return segmentRepository;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }
}
