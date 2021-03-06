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

    @Override
    public Iterable<Song> findAllByNameContaining(String name) {
        return iSongRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Song> findSongsByDateNewLimit10() {
        return iSongRepository.findSongsByDateNewLimit10();
    }

    @Override
    public Iterable<Song> findSongsByCategoryId(Long id) {
        return iSongRepository.findSongsByCategoryId(id);
    }

    @Override
    public Iterable<Song> findAllSongsByUserIdLike(Long id) {
        return iSongRepository.findSongsByUserIdAndStatus(id);
    }

    @Override
    public Iterable<Song> findSongsByPlaylistId(Long id) {
        return iSongRepository.findSongsByPlaylistID(id);
    }

    @Override
    public Iterable<Song> findSongsBySubId(Long id) {
        return iSongRepository.findSongsBySubId(id);
    }

    @Override
    public Iterable<Song> findSongsHaveNotInPlaylist(Long id) {
        return iSongRepository.findSongsHaveNotInPlaylist(id);
    }

  @Override
  public Iterable<Song> findSongsByCategoryName(String name) {
    return iSongRepository.findSongsByCategoryName(name);
  }

    @Override
    public Iterable<Song> findSongsBySingerName(String name) {
        return iSongRepository.findSongsBySingerName(name);
    }


    @Override
    public Iterable<Song> findSongsByDateNew() {
        return iSongRepository.findSongsByDateNew();
    }

    @Override
    public Iterable<Song> findSongsByMostLike() {
        return iSongRepository.findSongsByMostLike();
    }

}
