package com.sound.wave.service.song;

import com.sound.wave.model.Song;
import com.sound.wave.service.IGeneralService;
import org.springframework.stereotype.Service;


public interface ISongService extends IGeneralService<Song> {
    Iterable<Song> findSongsByName(String name);
}
