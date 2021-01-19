package com.sound.wave.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @ManyToOne
    private Category category;
    private String description;
    private LocalDateTime dateCreate;
    @ManyToOne
    private User user;
    private LocalDateTime timeUpdate;
    private Long views;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Song> songs;
}
