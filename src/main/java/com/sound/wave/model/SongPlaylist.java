package com.sound.wave.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SongPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Song song;

    @ManyToOne(fetch = FetchType.LAZY)
    private PlayList playList;
}
