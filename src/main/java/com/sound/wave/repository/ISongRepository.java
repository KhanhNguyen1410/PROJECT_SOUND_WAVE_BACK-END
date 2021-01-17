package com.sound.wave.repository;

import com.sound.wave.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
    Iterable<Song> findSongsByNameContaining(String name);
    @Modifying
    @Query(value = "select s.* from song as s " +
            "join play_list_songs as ps on s.id = ps.songs_id " +
            "join play_list as p on p.id = ps.play_list_id " +
            "where p.id = :id", nativeQuery = true)
    List<Song> findSongsByPlaylistID(@Param("id") Long id);

    @Query(value = "select * from song " +
            "order by views desc " +
            " limit 10", nativeQuery = true)
    List<Song> findByViewsLimit10();


    Song findSongById(Long id);

    @Query(value = "select * from song " +
            "order by song.date desc " +
            "limit 10", nativeQuery = true)
    List<Song> findSongsByDateNewLimit10();

    @Query(value = "select * from song where user_id=:id", nativeQuery = true)
    Iterable<Song> findSongsByIdUser(@Param("id") Long id);
}
