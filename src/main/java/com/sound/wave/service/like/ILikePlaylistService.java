package com.sound.wave.service.like;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.likePlaylist.LikePlaylist;
import com.sound.wave.service.IGeneralService;

public interface ILikePlaylistService extends IGeneralService<LikePlaylist> {
    Long findLikeByPlaylistId(Long id);
    LikePlaylist checkLikePlaylist(Long p_id, Long u_id);
    Iterable<PlayList> findPlaylistsByUserIdAndStatus(Long id);

}
