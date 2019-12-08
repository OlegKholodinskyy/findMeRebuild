package org.socialNetwork.controller;

import org.socialNetwork.models.User;
import org.socialNetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    List<User> users = new ArrayList<>();


    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable String userId) {

        User user = userService.getUser(userId);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping (path = "/users", method = RequestMethod.GET)
    public String users(Model model){

        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(path = "/users/new", method = RequestMethod.GET)
    public String newUser(){
        return "newUser";
    }

    @RequestMapping(path = "/users/new", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute User user){
        users.add(user);
        return "redirect:/users";
    }
}
