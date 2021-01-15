package com.sound.wave.repository.album;

import com.sound.wave.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends JpaRepository<Album, Long> {
}
