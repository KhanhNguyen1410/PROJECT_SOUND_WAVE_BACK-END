package com.sound.wave.repository.playlist;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IPlaylistRepository extends JpaRepository< PlayList, Long> {
    @Modifying
    @Query(value = "select * from play_list as p order by views desc limit 10", nativeQuery = true)
    Iterable<PlayList> findPlaylistsByViewsDesc();

    PlayList findPlayListById(Long id);

    @Query(value = "select * from play_list as pl where pl.id=?1 and pl.user_id=?2", nativeQuery = true)
    PlayList findPlaylistByIdAndUserId(Long id, Long id1);

    @Query(value = "select * from play_list as pl where pl.user_id = ?1", nativeQuery = true)
    Iterable<PlayList> findPlaylistByUserId(Long id);

    @Query(value = "select * from play_list as pl order by time_update desc limit 10", nativeQuery = true)
    Iterable<PlayList> findPlaylistNewUpdate();
    @Query(value = "select * from play_list as pl \n" +
            "where pl.id in ( select ls.play_list_id from like_playlist as ls \n" +
            "where ls.user_id =?1 and ls.status= 0)", nativeQuery = true)
    Iterable<PlayList> findPlaylistsByUserIdAndStatus(Long id);
    @Transactional
    @Modifying
    @Query(value ="UPDATE play_list pl set views = views + 1 where pl.id = :id", nativeQuery = true )
    void updateViews(@Param("id") Long id);
    
}
