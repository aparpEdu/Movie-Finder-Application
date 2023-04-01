package com.example.movies.authorization;


import com.example.movies.user.User;
import com.example.movies.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LogInController {
    private final UserService userService;

    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") User user, Model model) {

        boolean isUsernameEmpty = userService.isUsernameEmpty(user);
        boolean isPasswordEmpty = userService.isPasswordEmpty(user);

        if (isUsernameEmpty && isPasswordEmpty) {
            model.addAttribute("blankUsername", "Username cannot be empty");
            model.addAttribute("blankPassword", "Password cannot be empty");
            return "login";
        }

        if (isUsernameEmpty) {
            model.addAttribute("blankUsername", "Username cannot be empty");
            return "login";
        }

        if (isPasswordEmpty) {
            model.addAttribute("blankPassword", "Password cannot be empty");
            return "login";
        }

        boolean isUserAuthenticated = userService.authenticate(user);

        if (isUserAuthenticated) {
            return "redirect:/admin";
        } else {
            model.addAttribute("error", "Incorrect Username or Password");
            return "login";
        }


    }
        @GetMapping("/login")
    public String loginForm(Model model){
        LogInHelper.getInstance().setAdmin(false);
        return "login";
    }
}
