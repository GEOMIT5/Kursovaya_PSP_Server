package org.work.dao.mapper;

import org.work.dao.core.RowMapper;
import org.work.dao.mapper.builder.impl.UserRowMapperBuilder;
import org.work.domen.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {


    private static final int USER_ID = 1;
    private static final int USER_STATUS_ID = 2;
    private static final int USER_LOGIN = 3;
    private static final int USER_PASSWORD = 4;
    private static final int USER_NAME = 5;
    private static final int USER_SURNAME = 6;


    @Override
    public User mapRow(ResultSet set) throws SQLException {
        return
                new UserRowMapperBuilder(USER_ID, USER_STATUS_ID, USER_LOGIN, USER_PASSWORD, USER_NAME,
                        USER_SURNAME)
                        .getBuiltEntity(set);
    }
}
