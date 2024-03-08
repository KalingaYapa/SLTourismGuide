package com.project.sltourguide.controller;

import com.project.sltourguide.config.JwtUtil;
import com.project.sltourguide.entity.User;
import com.project.sltourguide.repository.UserRepository;
import com.project.sltourguide.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody final User user) {
        String jwtToken = this.jwtUtil.generateToken(userService.saveUser(user));
        log.info("User saved , jwt token :: {}", jwtToken);
        return ResponseEntity.ok(jwtToken);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody final User userRequest) {
        log.info("/authenticate called");
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userRequest.getEmail(),userRequest.getPassword()
        ));
        log.info("before retrive userdetail");
        final UserDetails userDetails = this.userRepository.findByEmail(userRequest.getEmail());
        log.info("after retrive userDetails id " , userDetails.getUsername());
        final String jwt = this.jwtUtil.generateToken(userDetails);
        log.info("jwt token after authenticated :: {}", jwt);
        return ResponseEntity.ok(jwt);
    }
}
