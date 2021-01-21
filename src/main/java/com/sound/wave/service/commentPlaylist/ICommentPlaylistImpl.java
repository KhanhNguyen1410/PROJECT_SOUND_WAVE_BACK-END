package com.sound.wave.service.commentPlaylist;

import com.sound.wave.model.commentPlaylist.CommentPlaylist;
import com.sound.wave.repository.ICommentPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ICommentPlaylistImpl implements ICommentPlaylist{
    @Autowired
    private ICommentPlaylistRepository commentPlaylistRepository;
    @Override
    public List<CommentPlaylist> findCommentPlaylistsByPlaylistId(Long id) {
        return commentPlaylistRepository.findCommentPlaylistsByPlaylistId(id);
    }

    @Override
    public Iterable<CommentPlaylist> findAll() {
        return commentPlaylistRepository.findAll();
    }

    @Override
    public CommentPlaylist save(CommentPlaylist commentPlaylist) {
        return commentPlaylistRepository.save(commentPlaylist);
    }

    @Override
    public Optional<CommentPlaylist> findById(Long id) {
        return commentPlaylistRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
    }
}

