package by.it.academy.messenger.controller.web.controllers;

import by.it.academy.messenger.services.api.IAuthService;
import by.it.academy.messenger.services.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    private final IAuthService authService;
    private final IUserService userService;
    private final String URL_FORWARD_KEY = "signIn";

    public SignInController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return URL_FORWARD_KEY;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestParam(name = "login") String login,
                         @RequestParam(name = "password") String password,
                         HttpSession session,
                         Model model) {

        if (!authService.authentication(login, password)) {
            model.addAttribute("inf", "Логин и(или) пароль неверные(ый)");
            return URL_FORWARD_KEY;
        } else {
            session.setAttribute("user", userService.get(login));
            return "redirect:/";
        }
    }
}
