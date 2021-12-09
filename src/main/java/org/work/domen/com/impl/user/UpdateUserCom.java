package org.work.domen.com.impl.user;

import org.work.domen.com.Com;
import org.work.domen.entity.User;
import org.work.domen.message.Message;
import org.work.domen.service.UserService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class UpdateUserCom implements Com {


    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {
        User user = (User) request.getByKey("user");

        Message response = new Message();
        try {
            userService.updateUser(user);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }
        return response;
    }

}
