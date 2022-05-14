package by.it.academy.messenger.controller.web.controllers;

import by.it.academy.messenger.model.User;
import by.it.academy.messenger.services.api.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/editProfile")
public class EditProfileController {

    private final IUserService userService;

    public EditProfileController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(@SessionAttribute(name = "user", required = false) User user) {
        if (user == null) {
            throw new SecurityException("Ошибка безопасности");
        }

        return "editProfile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String update(@SessionAttribute(name = "user", required = false) User user,
                         @RequestParam(name = "password", required = false) String password,
                         @RequestParam(name = "name", required = false) String name,
                         @RequestParam(name = "birthday", required = false) String birthdayRaw,
                         HttpSession session,
                         Model model) {
        if (user == null) {
            throw new SecurityException("Ошибка безопасности");
        }


        LocalDate birthday = null;
        if (birthdayRaw != null && !birthdayRaw.isEmpty()) {
            birthday = LocalDate.parse(birthdayRaw);
        }

        User userUpdate = new User(user.getLogin(), password, name, birthday);

        User resultUser = this.userService.update(userUpdate, user.getLogin());

        session.setAttribute("user", resultUser);
        model.addAttribute("inf", "Данные успешно обновлены");
        return "mainPage";
    }
}
