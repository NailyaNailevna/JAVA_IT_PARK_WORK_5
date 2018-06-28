package ru.itpark.milkyKitchen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itpark.milkyKitchen.services.UserService;

/**
 * Created by nailya.shakirova on 28.06.2018.
 */
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "LoginPage";
    }
}
