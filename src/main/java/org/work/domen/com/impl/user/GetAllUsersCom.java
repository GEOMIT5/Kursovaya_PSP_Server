package org.work.domen.com.impl.user;

import org.work.domen.com.Com;
import org.work.domen.entity.User;
import org.work.domen.message.Message;
import org.work.domen.service.UserService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

import java.util.List;

public class GetAllUsersCom implements Com {

    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        try {
            List<User> users = userService.getAll();
            response.add("users", users);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }

}
