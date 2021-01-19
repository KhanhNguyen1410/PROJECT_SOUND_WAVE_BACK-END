package com.sound.wave.service.like;

import com.sound.wave.model.likePlaylist.LikePlaylist;
import com.sound.wave.repository.like.ILikePlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ILikePlaylistServiceImpl implements ILikePlaylistService{
    @Autowired
    private ILikePlaylistRepository repository;
    @Override
    public Iterable<LikePlaylist> findAll() {
        return null;
    }

    @Override
    public LikePlaylist save(LikePlaylist likePlaylist) {
        return null;
    }

    @Override
    public Optional<LikePlaylist> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Long findLikeByPlaylistId(Long id) {
        return repository.findLikeByPlaylistId(id);
    }
}
