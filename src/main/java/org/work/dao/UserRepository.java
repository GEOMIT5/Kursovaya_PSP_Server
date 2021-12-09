package org.work.dao;

import org.work.dao.core.CrudRepository;
import org.work.dao.exception.DAOException;
import org.work.domen.entity.User;
import org.work.domen.entity.UserStatus;

import java.util.List;

public interface UserRepository extends CrudRepository<User> {

    @Override
    User getEntityById(String id) throws DAOException;

    @Override
    boolean removeById(String id) throws DAOException;

    @Override
    boolean add(User user) throws DAOException;

    @Override
    boolean update(User user) throws DAOException;

    @Override
    List<User> getAll() throws DAOException;

    void updateUserPassword(String userId, String newPassword) throws DAOException;

    User getPatientByLoginAndPassword(String login, String password) throws DAOException;

    void updateUserStatus(String userId, UserStatus status) throws DAOException;
}
