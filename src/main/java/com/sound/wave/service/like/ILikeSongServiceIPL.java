package com.sound.wave.service.like;

import com.sound.wave.model.likeSong.LikeSong;
import com.sound.wave.repository.like.ILikeSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ILikeSongServiceIPL implements ILikeSongService {
    @Autowired
    private ILikeSongRepository iLikeSongRepository;
    @Override
    public Iterable<LikeSong> findAll() {
        return iLikeSongRepository.findAll();
    }

    @Override
    public LikeSong save(LikeSong likeSong) {
        return iLikeSongRepository.save(likeSong);
    }

    @Override
    public Optional<LikeSong> findById(Long id) {
        return iLikeSongRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
            iLikeSongRepository.deleteById(id);
    }

    @Override
    public Long findLikeBySongId(Long id) {
        return  iLikeSongRepository.findLikeBySongId(id);
    }

    @Override
    public LikeSong findLikeSongByUserAndSong(long s_id, long u_id) {
        return iLikeSongRepository.checkLike(s_id, u_id);
    }

    @Override
    public LikeSong unLikeSong(Long id) {
         iLikeSongRepository.unLikeSong(id);
         return iLikeSongRepository.findById(id).get();
    }

    @Override
    public LikeSong LikeSong(Long id) {
        iLikeSongRepository.likeSong(id);
        return iLikeSongRepository.findById(id).get();
    }
}
