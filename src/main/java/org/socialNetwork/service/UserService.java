package org.socialNetwork.service;

import org.socialNetwork.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Optional<User> getUser(Long userId);

    public List<User> listAll();

    public User add(User user);

    public User findByFirstName(String firstName);
}
