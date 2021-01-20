package com.sound.wave.repository;

import com.sound.wave.model.SongPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongPlaylistRepository extends JpaRepository<SongPlaylist, Long> {
    @Query(value = "select * from song_playlist as sp where sp.play_list_id=?1",nativeQuery = true)
    Iterable<SongPlaylist> findByPlaylistId(Long id);
}
