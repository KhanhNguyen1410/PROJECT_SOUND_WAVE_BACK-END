package com.sound.wave.repository;

import com.sound.wave.model.PlayList;
import com.sound.wave.model.commentPlaylist.CommentPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentPlaylistRepository extends JpaRepository<CommentPlaylist, Long> {
    @Query(value = "SELECT * FROM comment_playlist as cp where cp.play_list_id = ?1", nativeQuery = true)
    List<CommentPlaylist> findCommentPlaylistsByPlaylistId(Long id);

}

