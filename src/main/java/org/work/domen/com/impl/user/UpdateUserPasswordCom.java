package org.work.domen.com.impl.user;

import org.work.domen.com.Com;
import org.work.domen.message.Message;
import org.work.domen.service.UserService;
import org.work.domen.service.exception.ServiceException;
import org.work.domen.service.factory.ServiceFactory;

public class UpdateUserPasswordCom implements Com {


    private final UserService userService = ServiceFactory.getInstance().getUserService();


    @Override
    public Message execute(Message request) {
        String userId = (String) request.getByKey("userId");
        String curPass = (String) request.getByKey("curPass");
        String newPass = (String) request.getByKey("newPass");
        String newPassConf = (String) request.getByKey("newPassConf");

        Message response = new Message();
        //

        try {
            userService.updateUserPassword(userId, curPass, newPass, newPassConf);
        } catch (ServiceException e) {
            response.add("ex", e.getMessage());
        }

        return response;
    }


}
