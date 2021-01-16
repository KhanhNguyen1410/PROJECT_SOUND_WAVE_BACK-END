package com.sound.wave.controller.user;

import com.sound.wave.model.Role;
import com.sound.wave.model.User;
import com.sound.wave.model.UserPrinciple;
import com.sound.wave.service.role.IRoleService;
import com.sound.wave.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @GetMapping()
    public ResponseEntity<Iterable<User>> findAllUser(){
        return new ResponseEntity<>( iUserService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user-current/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(iUserService.findUserByUsername(username), HttpStatus.OK);
    }

}
