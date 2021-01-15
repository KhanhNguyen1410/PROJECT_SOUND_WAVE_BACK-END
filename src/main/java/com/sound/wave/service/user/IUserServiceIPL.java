package com.sound.wave.service.user;

import com.sound.wave.model.User;
import com.sound.wave.model.UserPrinciple;
import com.sound.wave.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IUserServiceIPL implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
            iUserRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username);

        return UserPrinciple.build(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Override
    public boolean checkUser(String username) {
        if (iUserRepository.findByUsername(username) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkPassword(String username, String password) {
        String userPassword = iUserRepository.findByUsername(username).getPassword();
        CharSequence passwordEncode = password;
        if (passwordEncoder.matches(passwordEncode, userPassword)) {
            return true;
        } else {
            return false;
        }
    }
}
