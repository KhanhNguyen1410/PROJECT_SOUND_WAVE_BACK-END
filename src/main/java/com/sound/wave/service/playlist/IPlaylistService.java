package com.sound.wave.service.playlist;

import com.sound.wave.model.PlayList;
import com.sound.wave.service.IGeneralService;

public interface IPlaylistService extends IGeneralService<PlayList> {
    Iterable<PlayList> findPlaylistByViews();
    PlayList findPlaylistById(Long id);
    PlayList findPlaylistByIdAndUserId(Long id, Long id1);
    Iterable<PlayList> findPlaylistsByUserId(Long id);
    Iterable<PlayList> findPlaylistNewUpdate();
    Iterable<PlayList> findPlaylistsByUserIdAndStatus(Long id);

}
