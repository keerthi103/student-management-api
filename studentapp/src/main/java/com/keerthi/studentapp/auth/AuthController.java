package com.keerthi.studentapp.auth;

import com.keerthi.studentapp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if ("keerthi".equals(username) && "password123".equals(password)) {
            String token = jwtUtil.generateToken(username);
            return Map.of("token", token);
        }

        return Map.of("error", "Invalid credentials");
    }
}