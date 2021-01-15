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

    @PutMapping("/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        Optional<User> user1= iUserService.findById(id);
        if (!user1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        user1.get().setFullName(user.getFullName());
        user1.get().setAddress(user.getAddress());
        user1.get().setEmail(user.getEmail());
        user1.get().setAvatar(user.getAvatar());

            iUserService.save(user1.get());
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/password")
    public ResponseEntity<User> updatePassword(@RequestBody String password){
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
