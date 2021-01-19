package com.sound.wave.repository.like;

import com.sound.wave.model.likePlaylist.LikePlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikePlaylistRepository extends JpaRepository<LikePlaylist, Long> {
    @Query(value = "select count(lp.user_id) as amount from like_playlist as lp " +
            " where lp.status= 0 and lp.play_list_id= ?1", nativeQuery = true)
    Long findLikeByPlaylistId(Long id);
}
