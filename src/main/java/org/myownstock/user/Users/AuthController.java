package org.myownstock.user.Users;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.myownstock.user.Users.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {

    @Autowired
    AuthService authservice;



    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid Credentials c) {
        try {
            User savedUser = this.authservice.signUp(c.toUser()).toPublicUser();
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
        }
    }

    // signin
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody User u, HttpServletResponse response) {
        User authenticatedUser = this.authservice.signIn(u);
        final var token = this.authservice.generateToken(authenticatedUser);
        Cookie cookie = new Cookie("authToken", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/tabs");
        cookie.setMaxAge(100);
        response.addCookie(cookie);

        return ResponseEntity.ok().body(authenticatedUser.toPublicUser());
    }
}
