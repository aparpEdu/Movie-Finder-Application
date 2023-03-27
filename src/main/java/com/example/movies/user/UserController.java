package com.example.movies.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class UserController {

private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();

    }

//    @PostMapping("/admin")
//    public String processLoginForm(@RequestParam String username, @RequestParam String password, Model model,User user) {
//        boolean isValid = userService.authenticate(username, password);
//        if (isValid) {
//            return "redirect:/home";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//
//    }
    @PostMapping
    public void signUpUser(@RequestBody User user) throws IllegalAccessException {
        userService.addNewUser(user);
    }
}
