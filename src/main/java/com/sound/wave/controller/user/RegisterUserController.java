package com.sound.wave.controller.user;

import com.sound.wave.model.Role;
import com.sound.wave.model.User;
import com.sound.wave.service.role.IRoleService;
import com.sound.wave.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/register")
public class RegisterUserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User user) {
        Role role = iRoleService.findRoleByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (iUserService.checkUser(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            iUserService.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
