package co.edu.udemedellin.airbnb_backend.controller;

import co.edu.udemedellin.airbnb_backend.dto.AuthRequest;
import co.edu.udemedellin.airbnb_backend.security.JwtUtil;
import co.edu.udemedellin.airbnb_backend.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(CustomUserDetailsService userDetailsService, AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register/")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
        userDetailsService.registerUser(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/login/")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                authRequest.getPassword()));
        String token = jwtUtil.generateToken(authRequest.getUsername());
        //return ResponseEntity.ok(token);
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(token);
        } else {
            ResponseEntity.status(500).body("Hello");
            throw new RuntimeException("Invalid credentials!");
        }

    }
}
