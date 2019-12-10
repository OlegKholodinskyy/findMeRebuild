package org.socialNetwork.dao;

import org.socialNetwork.models.User;

import java.util.List;

/**
 * Created by oleg on 10.12.2019.
 */
public interface UserDao {

    public List<User> listAll();

    public User getOneById(Long id);

    public User getOneByName(String firstName);

    public User add(User user);
}
