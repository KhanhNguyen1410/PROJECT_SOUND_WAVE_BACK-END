package com.sound.wave.repository;

import com.sound.wave.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
    Iterable<Song> findSongsByNameContaining(String name);
}
