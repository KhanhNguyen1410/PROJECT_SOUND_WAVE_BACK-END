package com.sound.wave.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "please enter username")
    @Size(min = 2, max = 20, message = "Username length from 2 to 20 characters")
    private String username;
    @NotEmpty(message = "please enter password")
    private String password;
    private String phoneNumber;
    @Size(max = 30, message = "max is 30 word")
    private String fullName;
    @Size(max = 30, message = "max is 30 word")
    private String address;
    @NotEmpty(message = "please enter fullName ")
    @Email(message = "must be the correct email type")
    private String email;
    private String avatar;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


}
