package com.sound.wave.service.song;

import com.sound.wave.model.Song;
import com.sound.wave.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.Iterator;

public interface ISongService extends IGeneralService<Song> {
    Song findSongById(Long id);
    Iterable<Song> findAllByUserId( Long id);
    Song updateViews( Long id);
    Iterable<Song> findSongsByMostViews();
    Iterable<Song> findAllByNameContaining(String name);
}
