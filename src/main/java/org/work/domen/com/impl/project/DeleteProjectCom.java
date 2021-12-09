package org.work.domen.com.impl.project;

import org.work.domen.com.Com;
import org.work.domen.message.Message;
import org.work.domen.service.ProjectService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class DeleteProjectCom implements Com {

    private ProjectService projectService = ServiceFactory.getInstance().getProjectService();

    @Override
    public Message execute(Message request) {
        String projectId = (String) request.getByKey("projectId");
        Message response = new Message();
        try {
            projectService.deleteProject(projectId);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }
        return response;
    }
}
