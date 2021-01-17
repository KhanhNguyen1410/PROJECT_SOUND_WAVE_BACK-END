package com.sound.wave.repository.playlist;

import com.sound.wave.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository< PlayList, Long> {
    PlayList findPlayListById(Long id);
}
