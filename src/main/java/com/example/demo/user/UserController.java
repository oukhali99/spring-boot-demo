package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        // curl -X POST http://localhost:8080/api/v1/user -H "Content-Type: application/json" -d '{ "username": "user1", "passwordHash": "123" }'
        userService.addUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable(name = "userId") Long id) {
        // curl -X DELETE http://localhost:8080/api/v1/user/1

        if (id == 0) {
            userService.deleteAllUsers();
        }
        else {
            userService.deleteUser(id);
        }
    }
}
