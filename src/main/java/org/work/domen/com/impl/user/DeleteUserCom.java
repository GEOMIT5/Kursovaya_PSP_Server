package org.work.domen.com.impl.user;

import org.work.domen.com.Com;
import org.work.domen.message.Message;
import org.work.domen.service.UserService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class DeleteUserCom implements Com {

    private UserService service = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {
        String id = (String) request.getByKey("userId");
        Message response = new Message();
        try {
            service.deleteUser(id);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }


}
