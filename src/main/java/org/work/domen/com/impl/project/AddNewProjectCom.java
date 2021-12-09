package org.work.domen.com.impl.project;

import org.work.domen.com.Com;
import org.work.domen.entity.Project;
import org.work.domen.message.Message;
import org.work.domen.service.ProjectService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class AddNewProjectCom implements Com {

    private ProjectService projectService = ServiceFactory.getInstance().getProjectService();

    @Override
    public Message execute(Message request) {
        Project project = (Project) request.getByKey("project");
        Message response = new Message();
        try {
            projectService.addNewProject(project);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }
        return response;
    }
}
