package com.sound.wave.service.song;

import com.sound.wave.model.Song;
import com.sound.wave.service.IGeneralService;
import javafx.beans.property.SimpleLongProperty;
import org.springframework.data.repository.query.Param;

public interface ISongService extends IGeneralService<Song> {
    Song findSongById(Long id);
    Iterable<Song> findAllByUserId( Long id);
    Song updateViews( Long id);
    Iterable<Song> findSongsByMostViews();
    Iterable<Song> findSongsByDateNew();
    Iterable<Song> findSongsByMostLike();
    Iterable<Song> findAllByNameContaining(String name);
    Iterable<Song> findSongsByDateNewLimit10();
    Iterable<Song> findSongsByCategoryId(Long id);
    Iterable<Song> findAllSongsByUserIdLike(Long id);
    Iterable<Song> findSongsByPlaylistId(Long id);
    Iterable<Song> findSongsBySubId(Long id);
    Iterable<Song> findSongsHaveNotInPlaylist(Long id);
    Iterable<Song> findSongsByCategoryName(String name);
    Iterable<Song> findSongsBySingerName(String name);
}
