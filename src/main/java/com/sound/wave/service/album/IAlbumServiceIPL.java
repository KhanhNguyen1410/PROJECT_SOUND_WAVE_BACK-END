package com.sound.wave.service.album;


import com.sound.wave.model.Album;
import com.sound.wave.repository.album.IAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class IAlbumServiceIPL implements IAlbumService {
    @Autowired
    private IAlbumRepository iAlbumRepository;
    @Override
    public Iterable<Album> findAll() {
        return iAlbumRepository.findAll();
    }

    @Override
    public Album save(Album album) {
        return iAlbumRepository.save(album);
    }

    @Override
    public Optional<Album> findById(Long id) {
        return iAlbumRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iAlbumRepository.deleteById(id);
    }
}
