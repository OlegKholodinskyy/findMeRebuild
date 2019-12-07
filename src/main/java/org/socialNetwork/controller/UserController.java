package org.socialNetwork.controller;

import org.socialNetwork.models.User;
import org.socialNetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable String userId) {

        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        return "index";
    }
}
