package org.work.dao.impl.user;

import org.work.dao.UserRepository;
import org.work.dao.core.InitializerRepository;
import org.work.dao.core.exception.JdbcTemplateException;
import org.work.dao.exception.DAOException;
import org.work.dao.impl.DAOUtil;
import org.work.dao.mapper.UserRowMapper;
import org.work.domen.entity.User;
import org.work.domen.entity.UserStatus;

import java.util.List;

public class UserSqlRepository extends InitializerRepository implements UserRepository {

    @Override
    public User getEntityById(String id) throws DAOException {
        try {
            return jdbcTemplate.queryForObject(UserSqlUtil.GET_USER_BY_ID, new UserRowMapper(), id);
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void updateUserPassword(String userId, String newPassword) throws DAOException {
        try {
            jdbcTemplate.update(UserSqlUtil.UPDATE_USER_PASSWORD, newPassword, userId);
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws DAOException {
        try {
            jdbcTemplate.update(UserSqlUtil.DELETE_USER, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean add(User user) throws DAOException {
        if (DAOUtil.getInstance().isLoginUsed(user.getLogin())) {
            throw new DAOException("Логин уже занят!");
        }
        ///
        try {
            jdbcTemplate.update(UserSqlUtil.ADD_NEW_USER,
                    user.getUserStatus().getId(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getName(),
                    user.getSurname()
                    );
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean update(User user) throws DAOException {
        try {
            jdbcTemplate.update(UserSqlUtil.UPDATE_USER,
                    user.getUserStatus().getId(),
                    user.getLogin(),
                    user.getName(),
                    user.getSurname(),
                    user.getId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<User> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(UserSqlUtil.GET_ALL_USERS, new UserRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public User getPatientByLoginAndPassword(String login, String password) throws DAOException {
        try {
            return jdbcTemplate.queryForObject(UserSqlUtil.GET_BY_LOGIN_AND_PASSWORD, new UserRowMapper(), login, password);
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void updateUserStatus(String userId, UserStatus status) throws DAOException {
        try {
            jdbcTemplate.update(UserSqlUtil.UPDATE_USER_STATUS, status, userId);
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }
}
