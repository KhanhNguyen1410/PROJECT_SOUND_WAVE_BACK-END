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
    LikeSong checkLike(@Param("s_id") long s_id, @Param("u_id") long u_id);

    @Query(value = "select count(ls.user_id) as amount from like_song as ls \n" +
            "where ls.status= 0 and ls.song_id= ?1", nativeQuery = true)
    Long findLikeBySongId(Long id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE like_song ls set status = 1 where ls.id = :id", nativeQuery = true)
    void unLikeSong(@Param("id") Long id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE like_song ls set status = 0 where ls.id = :id", nativeQuery = true)
    void likeSong(@Param("id") Long id);

}
