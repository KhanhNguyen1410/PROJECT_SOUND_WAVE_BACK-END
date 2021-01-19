package com.sound.wave.model.commentSong;

import com.sound.wave.model.Song;
import com.sound.wave.model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class CommentSong {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Song song;
}
