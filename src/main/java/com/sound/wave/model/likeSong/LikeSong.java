package com.sound.wave.model.likeSong;

import com.sound.wave.model.Song;
import com.sound.wave.model.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LikeSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "boolean default false")
    private boolean status;
    @ManyToOne
    private User user;

    @ManyToOne
    private Song song;
}
