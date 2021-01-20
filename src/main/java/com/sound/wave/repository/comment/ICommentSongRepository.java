package com.sound.wave.repository.comment;

import com.sound.wave.model.commentSong.CommentSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentSongRepository extends JpaRepository<CommentSong, Long> {
    @Modifying
    @Query(value = "select * from comment_song as cs where cs.song_id= :id", nativeQuery = true)
    Iterable<CommentSong> findCommentSongsBySongId(@Param("id")Long id);
}
