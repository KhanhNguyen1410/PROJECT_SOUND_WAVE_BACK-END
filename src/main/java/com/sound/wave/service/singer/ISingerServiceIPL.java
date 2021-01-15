package com.sound.wave.service.singer;

import com.sound.wave.model.Singer;
import com.sound.wave.repository.singer.ISingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ISingerServiceIPL implements ISingerService {

    @Autowired
    private ISingerRepository iSingerRepository;
    @Override
    public Iterable<Singer> findAll() {
        return iSingerRepository.findAll();
    }

    @Override
    public Singer save(Singer singer) {
        return iSingerRepository.save(singer);
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return iSingerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iSingerRepository.deleteById(id);
    }
}
