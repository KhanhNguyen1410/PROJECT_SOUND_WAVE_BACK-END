package com.sound.wave.service.like;

import com.sound.wave.model.likeSong.LikeSong;
import com.sound.wave.service.IGeneralService;
import org.springframework.data.repository.query.Param;

public interface ILikeSongService extends IGeneralService<LikeSong> {
    LikeSong findLikeSongByUserAndSong(long s_id, long u_id);
    LikeSong unLikeSong( Long id);
    LikeSong LikeSong(Long id);
    Long findLikeBySongId(Long id);
}
