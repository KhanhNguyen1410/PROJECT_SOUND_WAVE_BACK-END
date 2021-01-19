package com.sound.wave.service.CommentSong;

import com.sound.wave.model.commentSong.CommentSong;
import com.sound.wave.repository.comment.ICommentSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ICommentSongImpl implements ICommentSong{
    @Autowired
    private ICommentSongRepository commentSongRepository;

    @Override
    public Iterable<CommentSong> findAll() {
        return null;
    }

    @Override
    public CommentSong save(CommentSong commentSong) {
        return null;
    }

    @Override
    public Optional<CommentSong> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public Iterable<CommentSong> findCommentsBySongId(Long id) {
        return commentSongRepository.findCommentSongsBySongId(id);
    }
}
