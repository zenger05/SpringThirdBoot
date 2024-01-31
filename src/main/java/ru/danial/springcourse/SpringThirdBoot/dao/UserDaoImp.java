package ru.danial.springcourse.SpringThirdBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.danial.springcourse.SpringThirdBoot.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User get(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getALL() {
       return entityManager.createQuery("From User user").getResultList();
    }

    @Override
    public void addOrUpdate(User user) {
        entityManager.merge(user);
    }


    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
