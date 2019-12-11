package org.socialNetwork.controller;

import org.socialNetwork.models.User;
import org.socialNetwork.service.UserService;
import org.socialNetwork.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;


    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable String userId) {

        Long id = Long.parseLong(userId);
        Optional<User> user = userService.getUser(id);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        List<User> users = userService.listAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(path = "/users/new", method = RequestMethod.GET)
    public String newUser(User user) {
        return "newUser";
    }

    @RequestMapping(path = "/users/new", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute @Valid User user,
                             BindingResult bindingResult,
                             Model model) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        userService.add(user);
        return "redirect:/users";
    }
}
