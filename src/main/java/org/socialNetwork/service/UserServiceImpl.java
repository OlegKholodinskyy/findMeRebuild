package org.socialNetwork.service;

import org.socialNetwork.models.User;
import org.socialNetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
/*
    @Autowired
    @Qualifier("jpaUserDaoImpl")
    UserDao userDao;
*/

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(Long userId) {
//        return userDao.getOneById(userId);
        return userRepository.findById(userId);
    }

    @Override
    public List<User> listAll() {
//        return userDao.listAll();
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User add(User user) {
//        return userDao.add(user);
        return userRepository.save(user);
    }

    public User findByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }
}
