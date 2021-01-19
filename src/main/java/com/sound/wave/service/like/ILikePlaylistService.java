package com.sound.wave.service.like;

import com.sound.wave.model.likePlaylist.LikePlaylist;
import com.sound.wave.service.IGeneralService;

public interface ILikePlaylistService extends IGeneralService<LikePlaylist> {
    Long findLikeByPlaylistId(Long id);
}
