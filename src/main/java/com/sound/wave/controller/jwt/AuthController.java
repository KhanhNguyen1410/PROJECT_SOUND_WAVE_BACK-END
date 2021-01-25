package com.sound.wave.controller.jwt;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.sound.wave.model.User;
import com.sound.wave.model.googleToken.GoogleToken;
import com.sound.wave.model.jwt.JwtResponse;
import com.sound.wave.service.jwt.JwtService;
import com.sound.wave.service.user.IUserService;
import com.sound.wave.service.user.IUserServiceIPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Iterator;
@RestController
@CrossOrigin("*")

public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService iUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateAccessToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/host")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("Trang chu", HttpStatus.OK);
    }
//    @PostMapping("/logout")
//    public ResponseEntity<?> logout(){
//
//    }
    @GetMapping("/email")
    public ResponseEntity<User> getUserByEmail(@RequestBody String email){
        User user= iUserService.findByEmail(email);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/googleSignIn")
    public ResponseEntity<?> receiveGoogletoken(@RequestBody GoogleToken googleToken) throws GeneralSecurityException, IOException {
       GoogleIdToken idToken = jwtService.validateGoogleToken(googleToken.getToken());
       System.out.println(idToken);
       if (idToken != null) {
        GoogleIdToken.Payload payload = idToken.getPayload();

        User checkUser = iUserService.findByEmail(payload.getEmail());
        if (checkUser != null) {
            String jwt = jwtService.generateAccessToken(checkUser);
            return ResponseEntity.ok(new JwtResponse(jwt, checkUser.getUsername()));
        }
        User user = new User();
        user.setEmail(payload.getEmail());
        user.setUsername( (String)payload.get("email"));
        user.setAvatar( (String) payload.get("picture"));
        user.setPhoneNumber("0123456789");
        user.setFullName((String) payload.get("family_name") + (String) payload.get("given_name"));
        user.setPassword(passwordEncoder.encode("12345678"));
        iUserService.save(user);
           String jwt = jwtService.generateAccessToken(checkUser);
        return ResponseEntity.ok(new JwtResponse(jwt, checkUser.getUsername()));
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
}
