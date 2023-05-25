package com.example.demo.auth;

import com.example.demo.auth.model.AuthenticationRequest;
import com.example.demo.auth.model.AuthenticationResponse;
import com.example.demo.auth.model.RegisterRequest;
import com.example.demo.config.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
