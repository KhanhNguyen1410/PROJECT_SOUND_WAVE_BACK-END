package com.sound.wave.repository;

import com.sound.wave.model.Song;
import com.sound.wave.model.SongPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongPlaylistRepository extends JpaRepository<SongPlaylist, Long> {
    @Query(value = "select * from song_playlist as sp where sp.play_list_id=?1",nativeQuery = true)
    Iterable<SongPlaylist> findByPlaylistId(Long id);


}
