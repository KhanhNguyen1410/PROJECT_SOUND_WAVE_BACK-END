package com.sound.wave.service.song;

import com.sound.wave.model.Song;
import com.sound.wave.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ISongServiceIPL implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Iterable<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public Song save(Song song) {
        return iSongRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
            iSongRepository.deleteById(id);
    }

    @Override
    public Iterable<Song> findSongsByName(String name) {
        return iSongRepository.findSongsByNameContaining(name);
    }

    @Override
    public List<Song> findSongsByPlaylistId(Long id) {
        return iSongRepository.findSongsByPlaylistID(id);
    }
}
