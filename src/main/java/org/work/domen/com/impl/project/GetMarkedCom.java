package org.work.domen.com.impl.project;

import org.work.domen.com.Com;
import org.work.domen.entity.Project;
import org.work.domen.message.Message;
import org.work.domen.service.ProjectService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

import java.util.List;

public class GetMarkedCom implements Com {

    private ProjectService projectService = ServiceFactory.getInstance().getProjectService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        try {
            List<Project> projects = projectService.getMarkedProject();
            response.add("projects", projects);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }
}
