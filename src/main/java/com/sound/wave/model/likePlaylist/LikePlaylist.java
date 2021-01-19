package com.sound.wave.model.likePlaylist;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.User;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Data
public class LikePlaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "boolean default false")
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private PlayList playList;
}
