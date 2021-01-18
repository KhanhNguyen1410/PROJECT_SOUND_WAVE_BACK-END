package com.sound.wave.service.song;

import com.sound.wave.model.Song;
import com.sound.wave.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Song findSongById(Long id) {
        return iSongRepository.findSongById(id);
    }

    @Override
    public Iterable<Song> findAllByUserId(Long id) {
        return iSongRepository.findAllByUserId(id);
    }

    @Override
    public Song updateViews(Long id) {
        iSongRepository.updateViews(id);
        Song song = iSongRepository.findById(id).get();
        return song;
    }

    @Override
    public Iterable<Song> findSongsByMostViews() {
        return iSongRepository.findSongsByMostViews();
    }

}
