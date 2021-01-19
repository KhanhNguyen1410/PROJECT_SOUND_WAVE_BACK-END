package com.sound.wave.model.commentPlaylist;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Data
public class CommentPlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private PlayList playList;

    public CommentPlaylist(String comment, LocalDateTime dateTime, User user, PlayList playList) {
        this.comment = comment;
        this.dateTime = dateTime;
        this.user = user;
        this.playList = playList;
    }
    public CommentPlaylist() {

    }
}
