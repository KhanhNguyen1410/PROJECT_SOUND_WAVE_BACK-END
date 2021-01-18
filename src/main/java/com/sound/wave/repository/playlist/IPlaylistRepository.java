package com.sound.wave.repository.playlist;

import com.sound.wave.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository< PlayList, Long> {
    @Modifying
    @Query(value = "select * from play_list as p order by views limit 10", nativeQuery = true)
    Iterable<PlayList> findPlaylistsByViewsDesc();

}
