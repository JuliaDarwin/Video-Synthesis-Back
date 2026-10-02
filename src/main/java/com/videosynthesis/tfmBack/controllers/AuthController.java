package com.videosynthesis.tfmBack.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;

import com.videosynthesis.tfmBack.models.UserEntity;
import com.videosynthesis.tfmBack.repositories.UserRepository;
import com.videosynthesis.tfmBack.repositories.RoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
// import com.videosynthesis.tfmBack.dto.Register;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.videosynthesis.tfmBack.dto.LoginDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.videosynthesis.tfmBack.security.JwtGenerator;
import com.videosynthesis.tfmBack.dto.AuthResponseDTO;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    // private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
            RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        // this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }
    // REGISTER BEING COMMENTED OUT BECAUSE PROJECT REQUIRES ONLY 1-2 ADMINS WHICH
    // WILL BE ADDED BY A SCRIPT OR DIRECTLY TO THE DB
    // @PostMapping("/register")
    // public ResponseEntity<String> register(@RequestBody Register registerdto) {
    // if (userRepository.existsByUsername(registerdto.getUsername())) {
    // return new ResponseEntity<>("Username already exists",
    // HttpStatus.BAD_REQUEST);
    // }
    // UserEntity user = new UserEntity();
    // user.setUsername(registerdto.getUsername());
    // user.setPassword(passwordEncoder.encode(registerdto.getPassword()));

    // userRepository.save(user);
    // return ResponseEntity.ok("User registered successfully");
    // }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
}
