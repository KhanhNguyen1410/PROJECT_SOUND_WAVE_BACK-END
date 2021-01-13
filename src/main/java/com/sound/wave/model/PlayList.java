package com.sound.wave.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Data
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    private String description;
    private Date dateCreate;
    @ManyToOne
    private User user;
    @ManyToOne
    private MusicGenres musicGenres;
    private Date timeUpdate;
    private Long views;
}
