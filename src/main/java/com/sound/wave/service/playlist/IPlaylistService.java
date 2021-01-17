package com.sound.wave.service.playlist;

import com.sound.wave.model.PlayList;
import com.sound.wave.service.IGeneralService;

public interface IPlaylistService extends IGeneralService<PlayList> {
    PlayList findPlaylistById(Long id);
}
