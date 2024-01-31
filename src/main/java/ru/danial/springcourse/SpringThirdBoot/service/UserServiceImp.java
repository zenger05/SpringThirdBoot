package ru.danial.springcourse.SpringThirdBoot.service;

import ru.danial.springcourse.SpringThirdBoot.dao.UserDao;
import ru.danial.springcourse.SpringThirdBoot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getALL() {
        return userDao.getALL();
    }

    @Override
    @Transactional
    public void addOrUpdate(User user) {
        userDao.addOrUpdate(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User get(int id) {
        return userDao.get(id);
    }
}
