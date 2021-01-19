package com.sound.wave.service.commentPlaylist;

import com.sound.wave.model.commentPlaylist.CommentPlaylist;
import com.sound.wave.service.IGeneralService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentPlaylist extends IGeneralService<CommentPlaylist> {
    List<CommentPlaylist> findCommentPlaylistsByPlaylistId(Long id);

}
