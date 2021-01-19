package com.sound.wave.service.CommentSong;

import com.sound.wave.model.commentSong.CommentSong;
import com.sound.wave.service.IGeneralService;

public interface ICommentSong  extends IGeneralService<CommentSong> {
    Iterable<CommentSong> findCommentsBySongId(Long id);
}
