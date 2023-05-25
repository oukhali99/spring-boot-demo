package com.example.demo.entities.user;

import com.example.demo.config.response.ResponseContentSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(
                new ResponseContentSuccess(userService.getUsers())
        );
    }
}
