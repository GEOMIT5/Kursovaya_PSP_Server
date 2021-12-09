package org.work.domen.com.impl;

import org.work.domen.com.Com;
import org.work.domen.entity.User;
import org.work.domen.message.Message;
import org.work.domen.service.UserService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class SignInCom implements Com {

    private UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {

        final String login = (String) request.getByKey("login");
        final String password = (String) request.getByKey("password");

        final Message response = new Message();

        try {
            User user = userService.signIn(login, password);
            if (user != null) {
                response.add("user", user);
            } else {
                response.add("ex", "Неверный логин или пароль!");
            }

        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }

}
