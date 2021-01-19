package com.sound.wave.service.like;

import com.sound.wave.model.likeSong.LikeSong;
import com.sound.wave.service.IGeneralService;

public interface ILikeSongService extends IGeneralService<LikeSong> {
    Long findLikeBySongId(Long id);
}
