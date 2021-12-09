package org.work.domen.service.impl;

import org.work.dao.UserRepository;
import org.work.dao.exception.DAOException;
import org.work.dao.factory.RepositoryFactory;
import org.work.domen.entity.User;
import org.work.domen.entity.UserStatus;
import org.work.domen.service.UserService;
import org.work.domen.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = RepositoryFactory.getInstance().getUserRepository();

    @Override
    public void addNewUser(User user) throws ServiceException {

        try {

            userRepository.add(user);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userRepository.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateUserPassword(String userId, String curPassword,
                                   String newPassword, String confNewPass) throws ServiceException {

        try {
            User user = userRepository.getEntityById(userId);
            if (!user.getPassword().equals(curPassword)) {
                throw new ServiceException("Неверный пароль!");
            }
            userRepository.updateUserPassword(userId, newPassword);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteUser(String id) throws ServiceException {
        try {
            userRepository.removeById(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<User> getAll() throws ServiceException {
        try {
            return userRepository.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public User signIn(String login, String password) throws ServiceException {
        try {
            return userRepository.getPatientByLoginAndPassword(login, password);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public void updateUserStatus(String userId, UserStatus status) throws ServiceException {
        try {
            userRepository.updateUserStatus(userId, status);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
