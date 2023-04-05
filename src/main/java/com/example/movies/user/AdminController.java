package com.example.movies.user;

import com.example.movies.authorization.LogInHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {


    @GetMapping("/admin")
    public String panel(Model model){
        if(LogInHelper.getInstance().isAdmin()) {
            return "admin";
        }
        return "login";
    }
}
