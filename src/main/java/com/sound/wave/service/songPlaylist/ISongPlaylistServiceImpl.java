package com.sound.wave.service.songPlaylist;

import com.sound.wave.model.SongPlaylist;
import com.sound.wave.repository.SongPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class ISongPlaylistServiceImpl implements ISongPlaylistService {

    @Autowired
    private SongPlaylistRepository repository;
    @Override
    public Iterable<SongPlaylist> findAll() {
        return repository.findAll();
    }

    @Override
    public SongPlaylist save(SongPlaylist songPlaylist) {
        return repository.save(songPlaylist);
    }

    @Override
    public Optional<SongPlaylist> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<SongPlaylist> findSongsByPlaylistId(Long id) {
        return repository.findByPlaylistId(id);
    }
}
