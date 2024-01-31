package ru.danial.springcourse.SpringThirdBoot.controller;


import jakarta.validation.Valid;
import ru.danial.springcourse.SpringThirdBoot.model.User;
import ru.danial.springcourse.SpringThirdBoot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String indexView(Model model) {
        List<User> listUser = userService.getALL();
        model.addAttribute("users", listUser);
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUserView(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUserField";
    }

    @RequestMapping("/addOrUpdate")
    public String add(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUserField";
        } else {
            userService.addOrUpdate(user);
            return "redirect:/";
        }
    }

    @RequestMapping("/removeUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("id") int id, Model model) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "addUserField";
    }
}
