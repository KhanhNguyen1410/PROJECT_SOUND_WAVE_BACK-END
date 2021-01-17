package com.sound.wave.service.song;

import com.sound.wave.model.Song;
import com.sound.wave.service.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISongService extends IGeneralService<Song> {
    Iterable<Song> findSongsByName(String name);
    List<Song> findSongsByPlaylistId(Long id);
    List<Song> findSongsByMostViews();
    Song findSongById(Long id);
    List<Song> findSongsByDateNew();
    Iterable<Song> findSongsByIdUser(Long id);
}
