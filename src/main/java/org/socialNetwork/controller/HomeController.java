package org.socialNetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("text", "testModel");
        return "index";
    }
}
