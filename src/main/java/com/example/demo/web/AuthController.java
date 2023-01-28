package com.example.demo.web;

import com.example.demo.dto.AuthCredentialRequest;
import com.example.demo.entities.Authority;
import com.example.demo.entities.User;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.UserDetailServiceImpl;
import com.example.demo.util.JWTUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    AuthorityService authorityService;

    @PostMapping(path = "login")
    public ResponseEntity<?> login(@RequestBody AuthCredentialRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            User user = (User) authenticate.getPrincipal();
            user.setPassword("");
            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            jwtUtil.generateToken(user)
                    )
                    .body(user);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping(path = "register")
    public ResponseEntity<?> register(@RequestBody User request) {

        try {
            userDetailService.createUser(request.getUsername(), request.getPassword(), request.getCohortStartDate());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).build();
        }
    }

    @PostMapping(path = "logout")
    public ResponseEntity<?> logout(@AuthenticationPrincipal User user) {

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/getRole/{id}")
    public ResponseEntity<?> getUserRole(@PathVariable Long id) {
        authorityService.getUserAuthority(id);
        return ResponseEntity.ok().build();
    }

}
