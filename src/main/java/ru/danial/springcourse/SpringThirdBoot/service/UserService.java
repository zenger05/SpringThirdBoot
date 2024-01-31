package ru.danial.springcourse.SpringThirdBoot.service;

import ru.danial.springcourse.SpringThirdBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getALL();

    void addOrUpdate(User user);


    void delete(int id);

    User get(int id);
}
