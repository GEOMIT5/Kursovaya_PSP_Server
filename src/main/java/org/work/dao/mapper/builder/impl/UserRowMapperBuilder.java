package org.work.dao.mapper.builder.impl;

import org.work.dao.mapper.builder.RowMapperBuilder;
import org.work.domen.entity.User;
import org.work.domen.entity.UserStatus;
import org.work.domen.utilit.builder.impl.UserBuilderImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapperBuilder implements RowMapperBuilder<User> {

    private final int USER_ID;
    private final int USER_STATUS_ID;
    private final int USER_LOGIN;
    private final int USER_PASSWORD;
    private final int USER_NAME;
    private final int USER_SURNAME;


    public UserRowMapperBuilder(int USER_ID, int USER_STATUS_ID, int USER_LOGIN,
                                int USER_PASSWORD, int USER_NAME, int USER_SURNAME) {
        this.USER_ID = USER_ID;
        this.USER_STATUS_ID = USER_STATUS_ID;
        this.USER_LOGIN = USER_LOGIN;
        this.USER_PASSWORD = USER_PASSWORD;
        this.USER_NAME = USER_NAME;
        this.USER_SURNAME = USER_SURNAME;

    }

    @Override
    public User getBuiltEntity(ResultSet set) throws SQLException {
        return doBuildPatient(set);
    }


    private User doBuildPatient(ResultSet set) throws SQLException {
        final int userStatusId = set.getInt(USER_STATUS_ID) - 1; // because arrays start from 0
        final UserStatus userStatus = UserStatus.values()[userStatusId];

        return
                new UserBuilderImpl(set.getString(USER_ID))
                        .withUserStatus(userStatus)
                        .withLogin(set.getString(USER_LOGIN))
                        .withPassword(set.getString(USER_PASSWORD))
                        .withName(set.getString(USER_NAME))
                        .withSurname(set.getString(USER_SURNAME))
                        .build();
    }


}
