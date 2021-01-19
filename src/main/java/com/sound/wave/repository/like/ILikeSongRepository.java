package com.sound.wave.repository.like;

import com.sound.wave.model.Song;
import com.sound.wave.model.likeSong.LikeSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface ILikeSongRepository extends JpaRepository<LikeSong, Long> {
    @Query(value = "select * from like_song as ls where song_id = :s_id and user_id = :u_id", nativeQuery = true)
    Iterable<Song> findLikeSongByUserAndSong(@Param("s_id") long s_id, @Param("u_id") long u_id);
}
