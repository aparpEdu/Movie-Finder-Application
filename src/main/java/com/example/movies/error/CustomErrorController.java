package com.example.movies.error;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Do something like logging
        return "error";
    }



    public String getErrorPath() {
        return "/error";
    }

}
