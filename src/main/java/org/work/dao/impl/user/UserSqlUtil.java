package org.work.dao.impl.user;

final class UserSqlUtil {


    static final String ADD_NEW_USER =
            "insert  into users(user_id, user_status_id, login, password, name, surname)" +
                    " values(UUID(), ?  , ? , ? , ? , ? )";

    static final String UPDATE_USER_PASSWORD =
            "update users set password=? where user_id = ? ";

    static final String UPDATE_USER =
            "update users set user_status_id= ? , login=?, name=?, surname=?" +
                    " where user_id = ?";

    static final String UPDATE_USER_STATUS =
            "update users set user_status_id = ? where user_id = ? ";

    static final String DELETE_USER =
            "delete from users where user_id=?";

    static final String GET_BY_LOGIN_AND_PASSWORD =
            "select user_id, user_status_id, login, password, name, surname" +
                    " from users where login = ? and password = ? ";

    static final String GET_ALL_USERS =
            "select user_id, user_status_id, login, password, name, surname" +
                    " FROM users";

    static final String GET_USER_BY_ID =
            "select user_id, user_status_id, login, password, name, surname" +
                    " FROM users where user_id=?";

}
