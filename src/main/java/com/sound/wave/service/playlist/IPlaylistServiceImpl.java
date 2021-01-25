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

    @Override
    public PlayList findPlaylistByIdAndUserId(Long id, Long id1) {
        return playlistRepository.findPlaylistByIdAndUserId(id, id1);
    }

    @Override
    public Iterable<PlayList> findPlaylistsByUserId(Long id) {
        return playlistRepository.findPlaylistByUserId(id);
    }

    @Override
    public Iterable<PlayList> findPlaylistNewUpdate() {
        return playlistRepository.findPlaylistNewUpdate();
    }

    @Override
    public Iterable<PlayList> findPlaylistsByUserIdAndStatus(Long id) {
        return playlistRepository.findPlaylistsByUserIdAndStatus(id);
    }

    @Override
    public PlayList updateViews(Long id) {
        playlistRepository.updateViews(id);
        PlayList playList = playlistRepository.findById(id).get();
        return playList;
    }
}
