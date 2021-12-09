package org.work.domen.com.factory;

import org.work.domen.com.Com;
import org.work.domen.com.Coms;
import org.work.domen.com.impl.SignInCom;
import org.work.domen.com.impl.project.*;
import org.work.domen.com.impl.segment.AddNewSegmentCom;
import org.work.domen.com.impl.segment.DeleteSegmentCom;
import org.work.domen.com.impl.segment.GetAllSegmentsCom;
import org.work.domen.com.impl.segment.UpdateSegmentCom;
import org.work.domen.com.impl.user.*;


public class CommandFactory {


    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    private CommandFactory() {

    }


    public Com getCommand(Coms commandName) {

        switch (commandName) {
            case SIGN_IN:
                return new SignInCom();
            //
            case ADD_NEW_USER:
                return new AddNewUserCom();
            case GET_ALL_USERS:
                return new GetAllUsersCom();
            case SIGN_UP:
                return new SignUpCom();
            case UPDATE_USER:
                return new UpdateUserCom();
            case DELETE_USER:
                return new DeleteUserCom();
            case UPDATE_USER_PASSWORD:
                return new UpdateUserPasswordCom();
            //
            case ADD_NEW_SEGMENT:
                return new AddNewSegmentCom();
            case UPDATE_SEGMENT:
                return new UpdateSegmentCom();
            case DELETE_SEGMENT:
                return new DeleteSegmentCom();
            case GET_ALL_SEGMENT:
                return new GetAllSegmentsCom();
            //
            case ADD_NEW_PROJECT:
                return new AddNewProjectCom();
            case UPDATE_PROJECT:
                return new UpdateProjectCom();
            case DELETE_PROJECT:
                return new DeleteProjectCom();
            case GET_ALL_PROJECT:
                return new GetProjectCom();

            case GET_ALL_MARKED_PROJECT:
                return new GetMarkedCom();
            case GET_ALL_NOT_MARKED_PROJECT:
                return new GetNotMarkedCom();

        }
        return null;
    }
}
