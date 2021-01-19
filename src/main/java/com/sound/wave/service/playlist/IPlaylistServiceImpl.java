package com.sound.wave.service.playlist;

import com.sound.wave.model.PlayList;
import com.sound.wave.repository.playlist.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IPlaylistServiceImpl implements IPlaylistService{
    @Autowired
    private IPlaylistRepository playlistRepository;
    @Override
    public Iterable<PlayList> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public PlayList save(PlayList playList) {
        return playlistRepository.save(playList);
    }

    @Override
    public Optional<PlayList> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public Iterable<PlayList> findPlaylistByViews() {
        return  playlistRepository.findPlaylistsByViewsDesc();
    }

    @Override
    public PlayList findPlaylistById(Long id) {
        return playlistRepository.findPlayListById(id);
    }
}
