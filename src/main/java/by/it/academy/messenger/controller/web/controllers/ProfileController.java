package by.it.academy.messenger.controller.web.controllers;

import by.it.academy.messenger.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(@SessionAttribute(name = "user", required = false) User user) {
        if (user == null) {
            throw new SecurityException("Ошибка безопасности");
        }

        return "profile";
    }
}
