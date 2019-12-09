package org.socialNetwork.util;

import org.socialNetwork.dao.UserDao;
import org.socialNetwork.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Autowired
    UserDao userDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (userDao.getOne(user.getFirstName()) != null){
            errors.rejectValue("firstName", "","User with username " + user.getFirstName() + " is present in DB");
        }
    }
}
