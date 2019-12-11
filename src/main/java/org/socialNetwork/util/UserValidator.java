package org.socialNetwork.util;

import org.socialNetwork.dao.UserDao;
import org.socialNetwork.models.User;
import org.socialNetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
/*
    @Autowired
    @Qualifier("jpaUserDaoImpl")
    UserDao userDao;
*/

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userService.findByFirstName(user.getFirstName()) != null) {
            errors.rejectValue("firstName", "", "User with username " + user.getFirstName() + " is present in DB");
        }
    }
}
