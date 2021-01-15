package com.sound.wave.service.user;

import com.sound.wave.model.User;
import com.sound.wave.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User findUserByUsername(String username);
    boolean checkUser(String username);
    boolean checkPassword(String username, String password);
}
