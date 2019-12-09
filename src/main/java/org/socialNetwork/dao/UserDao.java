package org.socialNetwork.dao;

import org.socialNetwork.models.User;

/**
 * Created by oleg on 07.12.2019.
 */
public class UserDao {

    public User getUser(String userId) {
        return new User(Long.parseLong(userId),"newUserName");
    }

    public Object getOne(String firstName) {
      //todo
        return new User();
    }
}
