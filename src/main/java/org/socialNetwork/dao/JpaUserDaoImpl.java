package org.socialNetwork.dao;

import org.socialNetwork.models.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
/*
Робота з Базою Даних винесена в пакет repository.
_________________________________________________
Даниий клас використовувася для ознайомлення з роботою EntityManager
____________________________________________________________________
 */

public class JpaUserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    private String getAllQuery = "SELECT * FROM USERS";
    private String getOneByFirstNameQuery = "SELECT * FROM USERS WHERE FIRST_NAME=?";

    @Override
    public List<User> listAll() {
        return entityManager.createNativeQuery(getAllQuery, User.class).getResultList();
    }

    @Override
    public User getOneById(Long id) {
//        Query q = entityManager.createNativeQuery(getOneByIdQuery, User.class);
//        q.setParameter("ID", id);
//        User user = (User) q.getResultList().stream().findAny().orElse(null);
//        User user;
//        try {
//            user = (User) entityManager.createNativeQuery(getOneByIdQuery, User.class)
//                    .setParameter("ID", id)
//                    .getSingleResult();
//        } catch (NoResultException e) {
//            user = null;
//        }

        return entityManager.find(User.class, id);

  //      return user;
    }

    @Override
    public User getOneByName(String firstName) {
//        Query q = entityManager.createNativeQuery(getOneByFirstNameQuery, User.class);
//        q.setParameter("FIRSTNAME", firstName);
//        User user = (User) q.getResultList().stream().findAny().orElse(null);

        User user;
        try {
            user = (User) entityManager.createNativeQuery(getOneByFirstNameQuery, User.class)
                    .setParameter(1, firstName)
                    .getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        return user;
    }

    @Override
    public User add(User user) {
        entityManager.persist(user);
        return user;
    }
}
