package org.socialNetwork.service;

import org.socialNetwork.dao.UserDao;
import org.socialNetwork.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by oleg on 07.12.2019.
 */
public class UserService {

    @Autowired
    @Qualifier("jpaUserDaoImpl")
    UserDao userDao;

    public User getUser(Long userId) {
        return userDao.getOneById(userId);
    }

    public List<User> listAll(){
        return userDao.listAll();
    }

    public User add(User user){
        return userDao.add(user);
    }
}
