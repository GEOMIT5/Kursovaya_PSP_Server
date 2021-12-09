package org.work.domen.com.impl.user;

import org.work.domen.com.Com;
import org.work.domen.entity.User;
import org.work.domen.entity.UserStatus;
import org.work.domen.message.Message;
import org.work.domen.service.UserService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;
import org.work.domen.utilit.builder.impl.UserBuilderImpl;

public class SignUpCom implements Com {

    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Message execute(Message request) {
        final String login = (String) request.getByKey("login");
        final String password = (String) request.getByKey("password");
        final String name = (String) request.getByKey("name");
        final String surname = (String) request.getByKey("surname");
        final UserStatus status = (UserStatus) request.getByKey("userStatus");

        final User user = new UserBuilderImpl()
                .withUserStatus(status)
                .withLogin(login)
                .withPassword(password)
                .withName(name)
                .withSurname(surname)
                .build();

        final Message response = new Message();
        try {
            userService.addNewUser(user);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }


}
