package org.socialNetwork.service;

import org.socialNetwork.dao.UserDao;
import org.socialNetwork.models.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by oleg on 07.12.2019.
 */
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUser(String userId) {
        return userDao.getUser(userId);
    }
}
