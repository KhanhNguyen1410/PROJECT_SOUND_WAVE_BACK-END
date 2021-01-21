package com.sound.wave.service.songPlaylist;

import com.sound.wave.model.SongPlaylist;
import com.sound.wave.service.IGeneralService;
import org.springframework.stereotype.Service;


public interface ISongPlaylistService extends IGeneralService<SongPlaylist> {
    Iterable<SongPlaylist> findSongsByPlaylistId(Long id);

}
