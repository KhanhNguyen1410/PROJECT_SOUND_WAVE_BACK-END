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
    public ResponseEntity<Iterable<User>> findAllUser() {
        return new ResponseEntity<>(iUserService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{username}")
    public ResponseEntity<User> findUserByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(iUserService.findUserByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Long id) {
        Optional<User> optionalUser = iUserService.findById(id);
        if (optionalUser.get() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(optionalUser, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<User>> updateUser(@RequestBody User user) {
        User user1 = iUserService.findUserByUsername(user.getUsername());
        user1.setFullName(user.getFullName());
        user1.setAddress(user.getAddress());
        user1.setEmail(user.getEmail());
        user1.setAvatar(user.getAvatar());

        iUserService.save(user1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/password")
    public ResponseEntity<User> updatePassword(@RequestBody String password) {
        User userCurrent = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.equals("anonymousUser")) {
            return null;
        }
        UserPrinciple userPrinciple = (UserPrinciple) principal;
        userCurrent = iUserService.findUserByUsername(userPrinciple.getUsername());
        userCurrent.setPassword(password);
        return new ResponseEntity<>(iUserService.save(userCurrent), HttpStatus.OK);
    }
}
