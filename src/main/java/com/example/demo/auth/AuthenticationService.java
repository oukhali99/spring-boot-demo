package com.example.demo.auth;

import com.example.demo.auth.config.JwtService;
import com.example.demo.auth.exception.AutenticationApiException;
import com.example.demo.auth.model.AuthenticationRequest;
import com.example.demo.auth.model.AuthenticationResponse;
import com.example.demo.auth.model.RegisterRequest;
import com.example.demo.config.response.ApiResponse;
import com.example.demo.entities.user.Role;
import com.example.demo.entities.user.User;
import com.example.demo.entities.user.UserService;
import com.example.demo.exception.ApiException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest request) {
        // Create a user
        User user = User.builder()
                .username(request.username())
                .passwordHash(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build()
                ;

        // Add the user to the database
        userService.addUser(user);

        // Create and return a jwt token
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @SneakyThrows
    public ApiResponse authenticate(AuthenticationRequest request) {
        // Verify that the credentials are valid (will throw an exception if not)
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username(),
                            request.password()
                    )
            );
        }
        catch (AuthenticationException e) {
            throw new AutenticationApiException(request.username());
        }

        // Get the user from the database
        UserDetails user = userService.loadUserByUsername(request.username());

        // Verify the password (not necessary since authenticationManager didn't throw an exception)
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new ApiException("Wrong password");
        }

        // Generate a jwt token and send it back
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
