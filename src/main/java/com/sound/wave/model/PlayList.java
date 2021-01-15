package com.sound.wave.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

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
    private LocalDate dateCreate;
    @ManyToOne
    @JsonIgnore
    private User user;
    private LocalDate timeUpdate;
    private Long views;
}
