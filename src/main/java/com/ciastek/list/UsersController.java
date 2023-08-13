package com.ciastek.list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {
    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping("/add")
    public String add(@RequestParam(required = false) String firstName,
                      @RequestParam String lastName,
                      @RequestParam(required = false, defaultValue = "0") Integer age) {

        if (firstName == null || firstName.equals("") || age <= 0) {
            return "redirect:/err.html";
        } else {
            User user = new User(firstName, lastName, age);
            usersRepository.add(user);
            return "redirect:/success.html";
        }
    }

    @ResponseBody
    @RequestMapping("/users")
    String usersList() {
        StringBuilder result = new StringBuilder();
        List<User> users =  usersRepository.getAll();
        for (User user : users) {
            result.append(user).append("<br/>");
        }
        return result.toString();
    }
}
