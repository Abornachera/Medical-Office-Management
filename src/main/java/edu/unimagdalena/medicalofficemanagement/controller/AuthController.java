package edu.unimagdalena.medicalofficemanagement.controller;

import edu.unimagdalena.medicalofficemanagement.dto.JwtResponse;
import edu.unimagdalena.medicalofficemanagement.dto.LoginRequest;
import edu.unimagdalena.medicalofficemanagement.security.jwt.JwtUtil;
import edu.unimagdalena.medicalofficemanagement.security.service.UserInfoDetail;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            UserInfoDetail userDetails = (UserInfoDetail) auth.getPrincipal();
            String jwt = jwtUtil.generateToken(userDetails.getUsername());

            return ResponseEntity.ok(new JwtResponse(jwt));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Usuario o contraseña inválidos");
        }
    }
}
