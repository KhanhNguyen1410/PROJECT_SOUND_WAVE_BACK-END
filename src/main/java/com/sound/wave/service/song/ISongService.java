package com.sound.wave.service.song;

import com.sound.wave.model.Song;
import com.sound.wave.service.IGeneralService;

public interface ISongService extends IGeneralService<Song> {
    Song findSongById(Long id);
}
