package com.sound.wave.repository.like;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.Song;
import com.sound.wave.model.likePlaylist.LikePlaylist;
import com.sound.wave.model.likeSong.LikeSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikePlaylistRepository extends JpaRepository<LikePlaylist, Long> {
    @Query(value = "select count(lp.user_id) as amount from like_playlist as lp " +
            " where lp.status= 0 and lp.play_list_id= ?1", nativeQuery = true)
    Long findLikeByPlaylistId(Long id);
    @Query(value = "select * from like_playlist as lp where lp.play_list_id = :p_id and lp.user_id = :u_id", nativeQuery = true)
    LikePlaylist checkLikePlaylist(@Param("p_id") long p_id, @Param("u_id") long u_id);



}
