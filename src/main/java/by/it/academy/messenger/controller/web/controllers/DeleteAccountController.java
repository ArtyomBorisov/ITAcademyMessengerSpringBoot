package by.it.academy.messenger.controller.web.controllers;

import by.it.academy.messenger.model.User;
import by.it.academy.messenger.services.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/deleteAccount")
public class DeleteAccountController {

    private final IUserService userService;

    public DeleteAccountController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String delete(@SessionAttribute(name = "user") User user,
                         HttpSession session) {
        this.userService.block(user.getLogin(), user.getLastUpdate());
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
