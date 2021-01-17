package com.sound.wave.repository;

import com.sound.wave.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
    Song findSongById(Long id);
    @Query(value = "select * from song r where r.user_id = :id", nativeQuery = true)
    Iterable<Song> findAllByUserId(@Param("id") Long id);
}
