package com.rabiloo.issue_logging.controllers.auth;

import com.rabiloo.issue_logging.DTO.Auth.AuthRequest;
import com.rabiloo.issue_logging.DTO.Auth.AuthResponse;
import com.rabiloo.issue_logging.DTO.Auth.RegisterRequest;
import com.rabiloo.issue_logging.domain.User;
import com.rabiloo.issue_logging.repositories.UserRepository;
import com.rabiloo.issue_logging.security.JwtService;
import com.rabiloo.issue_logging.security.UserDetailsServiceImpl;
import com.rabiloo.issue_logging.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthService authService;

    /**
     * Login endpoint to authenticate user and generate JWT token.
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        try {
            // Authenticate user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
            // Generate JWT token
            String token = jwtService.generateToken(authRequest.getEmail());
            // Return token in response
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            // Handle invalid authentication
            return ResponseEntity.status(401).body(new AuthResponse("Invalid credentials!"));
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        try {
            String response = authService.register(registerRequest);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            // Email is already in use
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * Endpoint to verify token and return authenticated user details.
     */
    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        if (jwtService.validateToken(token)) {
            String username = jwtService.extractUsername(token);
            return ResponseEntity.ok("Token is valid for user: " + username);
        } else {
            return ResponseEntity.status(401).body("Invalid token");
        }
    }
}
